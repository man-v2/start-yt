package com.yueting.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yueting.Repository.ItermRepository;
import com.yueting.model.Iterm;

@RestController
@RequestMapping("/api/iterm")
public class ItermRestController {
	Logger logger =  LoggerFactory.getLogger(getClass());
	
	@Autowired
	ItermRepository itermRepository;
	
	
	@GetMapping("/test")
	public Iterm test() {
		Iterm i = itermRepository.getOne(1);
		logger.info("iterm :"+i);
		return (i== null ? new Iterm() : i);
	}
	
	@GetMapping("/")
	public Long count() {
		return itermRepository.count();
	}
}
