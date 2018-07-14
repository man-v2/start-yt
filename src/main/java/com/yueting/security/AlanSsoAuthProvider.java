/**  
* @Title: AlanSsoAuthProvider.java
* @Package com.yueting.security
* @Description: TODO(用一句话描述该文件做什么)
* @author Administrator  
* @date 2018年7月14日 上午10:27:45
* @version V1.0  
*/ 
package com.yueting.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
* @ClassName: AlanSsoAuthProvider
* @Description: TODO(这里用一句话描述这个类的作用)
* @author Administrator
* @date 2018年7月14日 上午10:27:45
*
*/
@Component
public class AlanSsoAuthProvider implements AuthenticationProvider {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	/** 
	* <p>Title: authenticate</p>
	* <p>Description: </p>
	* @param authentication
	* @return
	* @throws AuthenticationException
	* @see org.springframework.security.authentication.AuthenticationProvider#authenticate(org.springframework.security.core.Authentication)
	*/
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		logger.debug("自定义provider");
		
		// 返回一个Token对象表示登陆成功
		return new UsernamePasswordAuthenticationToken(authentication.getPrincipal(), authentication.getCredentials());
	}

	/** 
	* <p>Title: supports</p>
	* <p>Description: </p>
	* @param authentication
	* @return
	* @see org.springframework.security.authentication.AuthenticationProvider#supports(java.lang.Class)
	*/
	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}

}
