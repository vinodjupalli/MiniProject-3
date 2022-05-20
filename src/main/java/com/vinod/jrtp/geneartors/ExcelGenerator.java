package com.vinod.jrtp.geneartors;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Component;

import com.vinod.jrtp.response.SearchResponse;


@Component
public class ExcelGenerator {
	public void generateExcel(List<SearchResponse> response, HttpServletResponse httpResponse) throws Exception{

	    HSSFWorkbook workbook = new HSSFWorkbook();
	    HSSFSheet sheet = workbook.createSheet("Plans");
	    HSSFRow headerRow = sheet.createRow(0);

	    headerRow.createCell(0).setCellValue("S.No");
	    headerRow.createCell(1).setCellValue("Plan Name");
	    headerRow.createCell(2).setCellValue("Plan Status");
	    headerRow.createCell(3).setCellValue("Case Number");
	    headerRow.createCell(4).setCellValue("Holder Name");
	    headerRow.createCell(5).setCellValue("Holder SSN");
	    headerRow.createCell(6).setCellValue("Benefit Amount");
	    headerRow.createCell(7).setCellValue("Denial Reason");
	    headerRow.createCell(8).setCellValue("Start Date");
	    headerRow.createCell(9).setCellValue("End Date");
	   

	    for (int i = 0; i < response.size(); i++) {
	      HSSFRow dataRow = sheet.createRow(i + 1);
	      SearchResponse record = response.get(i);
	      dataRow.createCell(0).setCellValue(i + 1);
	      if(record.getPlanName() !=null)
	      dataRow.createCell(1).setCellValue(record.getPlanName());
	      if(record.getPlanStatus() !=null)
	      dataRow.createCell(2).setCellValue(record.getPlanStatus());
	      if(record.getCaseNum() !=null)
	      dataRow.createCell(3).setCellValue(String.valueOf(record.getCaseNum()));
	      if(record.getHolderName() !=null)
	      dataRow.createCell(4).setCellValue(record.getHolderName());
	      if(record.getHolderSsn() !=null)
	      dataRow.createCell(5).setCellValue(record.getHolderSsn());
	      if(record.getBenefitAmt() !=null)
	      dataRow.createCell(6).setCellValue(String.valueOf(record.getBenefitAmt()));
	      if(record.getDenailReason() !=null)
	      dataRow.createCell(7).setCellValue(record.getDenailReason());
	      if(record.getStartDate() !=null)
	      dataRow.createCell(8).setCellValue(String.valueOf(record.getStartDate()));
	      if(record.getEndDate() !=null)
	      dataRow.createCell(9).setCellValue(String.valueOf(record.getEndDate()));
	     
	    }

	    workbook.write(httpResponse.getOutputStream());
	    workbook.close();
	  }
	}