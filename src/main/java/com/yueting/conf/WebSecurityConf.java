/**  
* @Title: WebSecurityConf.java
* @Package com.yueting.security
* @Description: TODO(用一句话描述该文件做什么)
* @author Administrator  
* @date 2018年7月14日 上午10:20:36
* @version V1.0  
*/
package com.yueting.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.yueting.service.UserService;

/**
 * @ClassName: WebSecurityConf
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Administrator
 * @date 2018年7月14日 上午10:20:36
 *
 */
@Configuration
public class WebSecurityConf extends WebSecurityConfigurerAdapter {
	private Logger logger = LoggerFactory.getLogger(getClass());

	private UserService userService;

	@Autowired
	    public WebSecurityConfiguration(UserService userService) {
	        this.userService = userService;
	    }

	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService);

	}
}
