package com.example.test.demo.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.demo.dto.ResponseClass;
import com.example.test.demo.feign_proxy.DataOperationServiceProxy;

import jakarta.websocket.server.PathParam;

@RestController
public class DemoController {

	@Autowired
	DataOperationServiceProxy proxy;
	
	@GetMapping("/")
	public void handleDefault() {
		System.out.println("Inside Handle default ");
	}
	@PostMapping("/")
	public void handleDefaultPost() {
		System.out.println("Inside Handle default POST ");
	}
	@GetMapping("/getdata")
	public ResponseClass getData() {
		System.out.println("Inside Get Data ");
		ResponseClass response = new ResponseClass("Success", 12);
		return response;
	}
	
	@PostMapping("/dataprovider/{a}/{b}")
	public ResponseClass dataProvider(@PathVariable int a , @PathVariable int b) {
		System.out.println("got data at service Provider MS "+ a+ " "+b  );
		System.out.println("Calling other MS with Feign Proxy");
		int sum = proxy.getSum(a, b);
		ResponseClass response = new ResponseClass("Success", sum);
		return response;
		
	}
}
