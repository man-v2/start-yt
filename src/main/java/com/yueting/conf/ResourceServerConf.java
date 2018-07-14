/**  
* @Title: ResourceServerConf.java
* @Package com.yueting.conf
* @Description: TODO(用一句话描述该文件做什么)
* @author Administrator  
* @date 2018年7月14日 上午10:59:20
* @version V1.0  
*/ 
package com.yueting.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
* @ClassName: ResourceServerConf
* @Description: TODO(这里用一句话描述这个类的作用)
* @author Administrator
* @date 2018年7月14日 上午10:59:20
*
*/
@Configuration
@EnableResourceServer
public class ResourceServerConf extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/**").authenticated()
			.anyRequest().authenticated();
	}
}
