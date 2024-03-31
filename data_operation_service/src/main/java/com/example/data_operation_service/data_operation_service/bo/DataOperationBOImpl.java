package com.example.data_operation_service.data_operation_service.bo;

import org.springframework.stereotype.Component;

@Component
public class DataOperationBOImpl implements DataOperationBO {

	@Override
	public int add(int a, int b) {
		System.out.println("At BO Layer : "+a +" b -> "+b);
		return (a+b);
	}

	@Override
	public int sub(int a, int b) {
		return (a*b);
	}

	@Override
	public int mul(int a, int b) {
		return (a-b);
	}

}
