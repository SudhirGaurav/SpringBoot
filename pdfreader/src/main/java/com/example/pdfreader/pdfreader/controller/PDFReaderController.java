package com.example.pdfreader.pdfreader.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

import com.spire.pdf.PdfDocument;
import com.spire.pdf.utilities.PdfTable;
import com.spire.pdf.utilities.PdfTableExtractor;

public class PDFReaderController {
	public static void pdfReader() {
		// Load a sample PDF document
		PdfDocument pdf = new PdfDocument("C:\\Users\\Admin\\git\\SpringBoot\\pdfreader\\src\\main\\java\\Balance_Sheet_Blank-1.pdf");

		System.out.println("PDF reader is : " + pdf);
		// Create a StringBuilder instance
		StringBuilder builder = new StringBuilder();
		// Create a PdfTableExtractor instance
		PdfTableExtractor extractor = new PdfTableExtractor(pdf);
		System.out.println("page size is : " + pdf.getPages().getCount());
		// Loop through the pages in the PDF
		for (int pageIndex = 0; pageIndex < pdf.getPages().getCount(); pageIndex++) {
			// Extract tables from the current page into a PdfTable array
			PdfTable[] tableLists = extractor.extractTable(pageIndex);
			System.out.println("Table lit is : " + tableLists.length);

			// If any tables are found
			if (tableLists != null && tableLists.length > 0) {
				// Loop through the tables in the array
				for (PdfTable table : tableLists) {
					// Loop through the rows in the current table
					// System.out.println("Table row count is : "+table.getRowCount());
					for (int i = 0; i < table.getRowCount(); i++) {
						// Loop through the columns in the current table
						// System.out.println("Table column count is : "+ table.getColumnCount());
						for (int j = 0; j < table.getColumnCount(); j++) {
							// Extract data from the current table cell and append to the StringBuilder
							String text = table.getText(i, j);
							System.out.println("TExt is : " + text);
							builder.append(text + " | ");
						}
						System.out.println("------------------------------------");
						builder.append("\r\n");
					}
				}
			}
		}
		// Write data into a .txt document
		FileWriter fw;
		try {
			fw = new FileWriter("ExtractTable.txt");
			fw.write(builder.toString());
			fw.flush();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void getPageNumberWhichHaveBalanceSheet() {
		 List<String> bsList= Arrays.asList("Balance Sheet","BalanceSheet");
		 String bsString = "Balance";
		try {
			// Create PdfReader instance.
			//PdfReader pdfReader = new PdfReader("C:\\Users\\Admin\\git\\SpringBoot\\pdfreader\\src\\main\\java\\Balance_Sheet_Blank-1.pdf");
			PdfReader pdfReader = new PdfReader("C:\\Users\\Admin\\Downloads\\Balance-Sheet-Example.pdf");

			
			// Get the number of pages in pdf.
			int pages = pdfReader.getNumberOfPages();

			// Iterate the pdf through pages.
			for (int i = 1; i <= pages; i++) {
				// Extract the page content using PdfTextExtractor.
				String pageContent = PdfTextExtractor.getTextFromPage(pdfReader, i);
				// Print the page content on console.
				System.out.println("Content on Page " + i + ": " + pageContent);
				if(pageContent.contains(bsString)) {
					System.out.println("Yesssssssssssssssssssssss got the page : "+i);
					break;
				}
				
			}

			// Close the PdfReader.
			pdfReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
