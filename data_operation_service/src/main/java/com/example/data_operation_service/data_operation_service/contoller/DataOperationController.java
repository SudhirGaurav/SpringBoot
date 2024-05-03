package com.example.data_operation_service.data_operation_service.contoller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.data_operation_service.data_operation_service.bo.DataOperationBO;

@RestController
public class DataOperationController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	DataOperationBO bo;

	@GetMapping("/")
	public void defaultSlash() {
		System.out.println("Inside Default Slash ");
	}
	@GetMapping("/test")
	public void test() {
		System.out.println("Inside Test...");
	}
	@GetMapping("/getsum/{a}/{b}")
	public int getSum(@PathVariable int a , @PathVariable int b) {
		logger.info(" logger Bo object is at Conroller is  : "+bo);
		System.out.println("Bo object is at Conroller is  : "+bo);
		return bo.add(a, b);
	}
}
