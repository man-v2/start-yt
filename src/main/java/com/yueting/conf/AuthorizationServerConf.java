/**
 * 
 */
package com.yueting.conf;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import com.yueting.service.UserService;

/**
 * 
 * @ClassName: AuthorizationServerConf
 * @Description: SpringCloudSecurityOauth2基于oauth2实现的授权服务器
 * @author Administrator
 * @date 2018年7月14日 上午10:01:10 使用JDBC存储token，首先要建表。框架为我们提前设计好了schema,
 *       在github上：https://github.com/spring-projects/spring-security-oauth/blob/master/spring-security-oauth2/src/test/resources/schema.sql
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConf extends AuthorizationServerConfigurerAdapter {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private DataSource dataSource;
	
//	@Autowired
	private UserService userService;
	
	@Autowired
	private TokenStore tokenStore;

	@Autowired
	private AuthenticationProvider authenticationProvider;

	@Bean // 声明TokenStore实现
	public TokenStore tokenStore() {
		return new JdbcTokenStore(dataSource);
	}

	@Bean // 声明 ClientDetails实现
	public ClientDetailsService clientDetail() {
		return new JdbcClientDetailsService(dataSource);
	}
	
	@Bean
    public AuthenticationManager authenticationManager() {
        return new ProviderManager(Arrays.asList(authenticationProvider));
    }

	/**
	 * <p>
	 * Title: 将token存储到MySQL
	 * </p>
	 * <p>
	 * Description: 完成这些后，框架就会将中间产生的数据写到mysql中了。
	 * oauth_client_details是client表，可以直接在该表中添加记录来添加client:
	 * </p>
	 * 
	 * @param endpoints
	 * @throws Exception
	 * @see org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter#configure(org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer)
	 */
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

		endpoints.authenticationManager(authenticationManager);
		endpoints.tokenStore(tokenStore());
		endpoints.userDetailsService(userService);

		// 配置TokenServices参数
		DefaultTokenServices tokenService = new DefaultTokenServices();
		tokenService.setTokenStore(endpoints.getTokenStore());
		tokenService.setSupportRefreshToken(true);
		tokenService.setClientDetailsService(endpoints.getClientDetailsService());
		tokenService.setTokenEnhancer(endpoints.getTokenEnhancer());
		// 存30天
		tokenService.setRefreshTokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(7));
		endpoints.tokenServices(tokenService);
	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.checkTokenAccess("permitAll()");
		security.allowFormAuthenticationForClients();
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.withClientDetails(clientDetail());
	}
	
	@Bean
    @Primary
    public DefaultTokenServices tokenServices() {
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setSupportRefreshToken(true); 
        tokenServices.setTokenStore(tokenStore); 
        return tokenServices;
    }
	
}
