/**  
* @Title: UserService.java
* @Package com.yueting.service
* @Description: TODO(用一句话描述该文件做什么)
* @author Administrator  
* @date 2018年7月14日 上午11:02:35
* @version V1.0  
*/ 
package com.yueting.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
* @ClassName: UserService
* @Description: 自定义UserService
* @author Administrator
* @date 2018年7月14日 上午11:02:35
*
*/
public interface UserService extends UserDetailsService {

}
