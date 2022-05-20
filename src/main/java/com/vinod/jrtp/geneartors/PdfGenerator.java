package com.vinod.jrtp.geneartors;

import java.awt.Color;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.vinod.jrtp.response.SearchResponse;

@Component
public class PdfGenerator {

	public void generatePdf(List<SearchResponse> records, HttpServletResponse response) throws Exception {

	    Document document = new Document();

	    PdfWriter writer = PdfWriter.getInstance(document, response.getOutputStream());

	    document.open();

	    Font font = new Font(Font.HELVETICA, 16, Font.BOLDITALIC, Color.RED);
	    Paragraph para = new Paragraph("Eligibility Details", font);
	    document.add(para);

	    PdfPTable table = new PdfPTable(10);

	    table.addCell("S.No");
	    table.addCell("Plan Name");
	    table.addCell("Plan Status");
	    table.addCell("Case Number");
	    table.addCell("Holder Name");
	    table.addCell("Holder SSN");
	    table.addCell("Benefit Amount");
	    table.addCell("Denial Reason");
	    table.addCell("Start Date");
	    table.addCell("End Date");
	   

	    int sno = 1;
	    for (SearchResponse record : records) {
	      table.addCell(String.valueOf(sno));
	      table.addCell(record.getPlanName());
	      table.addCell(record.getPlanStatus());
	      table.addCell(String.valueOf(record.getCaseNum()));
	      table.addCell(record.getHolderName());
	      table.addCell(String.valueOf(record.getHolderSsn()));
	      table.addCell(String.valueOf(record.getBenefitAmt()));
	      table.addCell(record.getDenailReason());
	      table.addCell(String.valueOf(record.getStartDate()));
	      table.addCell(String.valueOf(record.getEndDate()));
	     
	      sno++;
	    }

	    document.add(table);
	    document.close();
	    writer.close();
	  }
	}