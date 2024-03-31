package com.example.test.demo.feign_proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//feign client in spring cloud The root cause is feign client won't accept service name with under score
@FeignClient(name = "data-operation-service")
public interface DataOperationServiceProxy {

	@GetMapping("/getsum/{a}/{b}")
	public int getSum(@PathVariable  int a , @PathVariable int  b);
}
