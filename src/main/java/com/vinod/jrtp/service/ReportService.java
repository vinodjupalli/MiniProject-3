package com.vinod.jrtp.service;

import java.util.List;



import com.vinod.jrtp.request.SearchRequest;
import com.vinod.jrtp.response.SearchResponse;

public interface ReportService {

	public List<String> getPlanNames();
	public List<String> getPlanStatuses();
	public List<SearchResponse> search(SearchRequest request) ;
	
}
