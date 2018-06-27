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

import com.yueting.model.Iterm;

public interface ItermRepository extends JpaRepository<Iterm,Integer> {

}
