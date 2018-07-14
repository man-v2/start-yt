/**   
* @Title: UserRepository.java 
* @Package com.example.model 
* @Description: TODO(用一句话描述该文件做什么) 
* @author WX: skyone5  
* @date 2018年6月21日 下午5:26:25 
* @version V1.0   
*/
package com.yueting.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.yueting.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("select u from User u where u.id=?")
	User findById(Integer id);

	User findByName(String name);
}
