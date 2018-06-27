package com.yueting.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yueting.Repository.ItermRepository;
import com.yueting.model.Iterm;
import com.yueting.util.MsgCode;
import com.yueting.util.Result;

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
	public Result<List<Iterm>> count() {
		Result<List<Iterm>> result = new Result<List<Iterm>>();
		result.setCode(MsgCode.SUCCESS.getCode());
		result.setMsg(MsgCode.SUCCESS.getDescription());
		result.setData(itermRepository.findAll());
		return result;
	}
	
	@GetMapping(value="/{id}")
	public Result<Iterm> getById(@PathVariable(value = "id") Integer id){
		Result<Iterm> result = new Result<Iterm>();
		result.setCode(MsgCode.SUCCESS.getCode());
		result.setMsg(MsgCode.SUCCESS.getDescription());
		result.setData(itermRepository.getOne(id));
		return result;
	}
}
