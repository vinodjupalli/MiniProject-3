package com.vinod.jrtp.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.vinod.jrtp.entity.Eligibility;
import com.vinod.jrtp.repo.EligibilityRepository;
import com.vinod.jrtp.request.SearchRequest;
import com.vinod.jrtp.response.SearchResponse;
import com.vinod.jrtp.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService {
	@Autowired
	private EligibilityRepository repo;

	@Override
	public List<String> getPlanNames() {
		return repo.getUniquePlanNames();

	}

	@Override
	public List<String> getPlanStatuses() {
		return repo.getUniquePlanStatuses();
	}

	@Override
	public List<SearchResponse> search(SearchRequest request) {
		List<Eligibility> allRecords=null;
		if (isSRequestEmpty(request)) {
				allRecords = repo.findAll();
		}

		else {
			String planName = request.getPlanName();
			String planStatus = request.getPlanStatus();
			LocalDate startDate = request.getStartDate();
			LocalDate endDate = request.getEndDate();
			Eligibility entity = new Eligibility();
			if (planName != null && !planName.equals("")) {
				entity.setPlanName(planName);
			} 

			if (planStatus != null && !planStatus.equals("")) {
				entity.setPlanStatus(planStatus);
			}
			if (startDate != null & endDate != null) {
				entity.setStartDate(startDate);
				entity.setEndDate(endDate);
			}

			Example<Eligibility> of = Example.of(entity);
			allRecords = repo.findAll(of);
		}
		List<SearchResponse> response = new ArrayList<>();
		for (Eligibility elgRecord : allRecords) {
			SearchResponse sr = new SearchResponse();
			BeanUtils.copyProperties(elgRecord, sr);
			response.add(sr);
		}
		return response;
	}

	
	
	
	private boolean isSRequestEmpty(SearchRequest request)  {
		if(request==null) {
			return true;
		}
             
		if (request.getPlanName() != null && ! request.getPlanName().equals("")) {
			return false;
		}
		if (request.getPlanStatus() != null && ! request.getPlanStatus().equals("")) {
			return false;
		}
		if (request.getStartDate() != null && ! request.getStartDate().equals("")) {
			return false;
		}
		if (request.getEndDate() != null && ! request.getEndDate().equals("")) {
			return false;
		}
		return true;
	}

}
