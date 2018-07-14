/**  
* @Title: UserServiceImpl.java
* @Package com.yueting.service.impl
* @Description: TODO(用一句话描述该文件做什么)
* @author Administrator  
* @date 2018年7月14日 上午11:03:52
* @version V1.0  
*/
package com.yueting.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.yueting.Repository.UserRepository;
import com.yueting.model.User;
import com.yueting.service.UserService;

/**
 * @ClassName: UserServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Administrator
 * @date 2018年7月14日 上午11:03:52
 *
 */
public class UserServiceImpl implements UserService {
	Logger logger =  LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UserRepository userRepository;
	
	/**
	 * <p>
	 * Title: loadUserByUsername
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param username
	 * @return
	 * @throws UsernameNotFoundException
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		// 可以进行数据库请求，这里进行模拟
		User user = userRepository.findByName(userName);
		if (user == null) {
			logger.debug("没找到用户信息："+userName);
			throw new UsernameNotFoundException("Could not find the user by:  '" + userName + "'");
		}
		return new CustomUserDetails(user, true, true, true, true, null);
	}

}
