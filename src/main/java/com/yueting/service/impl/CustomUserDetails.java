/**  
* @Title: CustomUserDetails.java
* @Package com.yueting.service.impl
* @Description: TODO(用一句话描述该文件做什么)
* @author Administrator  
* @date 2018年7月14日 上午11:08:23
* @version V1.0  
*/
package com.yueting.service.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.yueting.model.User;

/**
 * @ClassName: CustomUserDetails
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Administrator
 * @date 2018年7月14日 上午11:08:23
 *
 */
public class CustomUserDetails implements UserDetails {

	private static final long serialVersionUID = -6372450874579543417L;
	
	private final boolean enabled;
	private final boolean accountNonExpired;
	private final boolean credentialsNonExpired;
	private final boolean accountNonLocked;
	private final Set<GrantedAuthority> authorities;
	

	public CustomUserDetails(User user, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
		if (user != null && !StringUtils.hasText(user.getName()) && !StringUtils.hasText(user.getPassword())) {
			setUsername
			setPassword(user.getPassword());
			this.enabled = enabled;
			this.accountNonExpired = accountNonExpired;
			this.credentialsNonExpired = credentialsNonExpired;
			this.accountNonLocked = accountNonLocked;
			this.authorities = Collections.unmodifiableSet(new HashSet<>(CollectionUtils.isEmpty(authorities)));
		} else {
			throw new IllegalArgumentException("Cannot pass null or empty values to constructor");
		}
	}

	/**
	 * <p>
	 * Title: getAuthorities
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @return
	 * @see org.springframework.security.core.userdetails.UserDetails#getAuthorities()
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * <p>
	 * Title: getPassword
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @return
	 * @see org.springframework.security.core.userdetails.UserDetails#getPassword()
	 */
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * <p>
	 * Title: getUsername
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @return
	 * @see org.springframework.security.core.userdetails.UserDetails#getUsername()
	 */
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * <p>
	 * Title: isAccountNonExpired
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @return
	 * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonExpired()
	 */
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	/**
	 * <p>
	 * Title: isAccountNonLocked
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @return
	 * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonLocked()
	 */
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	/**
	 * <p>
	 * Title: isCredentialsNonExpired
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @return
	 * @see org.springframework.security.core.userdetails.UserDetails#isCredentialsNonExpired()
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	/**
	 * <p>
	 * Title: isEnabled
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @return
	 * @see org.springframework.security.core.userdetails.UserDetails#isEnabled()
	 */
	@Override
	public boolean isEnabled() {
		return true;
	}

}
