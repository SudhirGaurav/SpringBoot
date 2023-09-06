package com.example.pdfreader.pdfreader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.pdfreader.pdfreader.controller.PDFReaderController;

@SpringBootApplication
public class PdfreaderApplication {

	public static void main(String[] args) {
		//SpringApplication.run(PdfreaderApplication.class, args);
		PDFReaderController controller = new PDFReaderController();
		//controller.pdfReader();
		controller.getPageNumberWhichHaveBalanceSheet();
	}

}
