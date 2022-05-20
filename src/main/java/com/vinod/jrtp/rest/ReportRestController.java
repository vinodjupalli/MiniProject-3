package com.vinod.jrtp.rest;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vinod.jrtp.geneartors.ExcelGenerator;
import com.vinod.jrtp.geneartors.PdfGenerator;
import com.vinod.jrtp.request.SearchRequest;
import com.vinod.jrtp.response.SearchResponse;
import com.vinod.jrtp.service.ReportService;

@RestController
public class ReportRestController {
    @Autowired
	private ReportService service;

	@GetMapping("/plan-names")
	public List<String> getPlanNames() {
		return service.getPlanNames();
	}

	@GetMapping("/plan-statuses")
	public List<String> getPlanStatuses() {
		return service.getPlanStatuses();
	}

	@PostMapping("/search")
	public List<SearchResponse> search(@RequestBody SearchRequest request) {
		return service.search(request);
	}

	@GetMapping("/excel")
	public void generateExcel(HttpServletResponse response) throws Exception {

		response.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=Plans.xls";
		response.setHeader(headerKey, headerValue);

		List<SearchResponse> records = service.search(null);
		ExcelGenerator excel = new ExcelGenerator();
		excel.generateExcel(records, response);
	}

	@GetMapping("/pdf")
	public void generatePdf(HttpServletResponse httpResponse) throws Exception {

		httpResponse.setContentType("application/pdf");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=Plans.pdf";
		httpResponse.setHeader(headerKey, headerValue);

		List<SearchResponse> records1 = service.search(null);
		PdfGenerator pdfGen = new PdfGenerator();
		pdfGen.generatePdf(records1, httpResponse);

	}
}
