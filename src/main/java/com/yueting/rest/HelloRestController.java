/**   
* @Title: HelloRestController.java 
* @Package com.example.rest 
* @Description: TODO(用一句话描述该文件做什么) 
* @author WX: skyone5  
* @date 2018年6月21日 下午4:13:00 
* @version V1.0   
*/
package com.yueting.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** 
* @ClassName: HelloRestController 
* @Description: For test
* @author WX: skyone5
* @date 2018年6月21日 下午4:13:00 
*  
*/
@RestController
@RequestMapping("/test")
public class HelloRestController {
	
	@GetMapping("/")
	public String index() {
		return "method: index";
	}

	@GetMapping("/hello")
	public String sayHello() {
		return "method: hello";
	}
}
