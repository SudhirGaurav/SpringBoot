package com.example.test.demo.dto;

public class ResponseClass {

	String responseMessage;
	int result ;
	
	
	public ResponseClass(String responseMessage, int result) {
		super();
		this.responseMessage = responseMessage;
		this.result = result;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	
	
}
