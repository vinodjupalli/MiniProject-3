package com.vinod.jrtp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vinod.jrtp.entity.Eligibility;

public interface EligibilityRepository extends JpaRepository<Eligibility, Integer> {
	@Query("select distinct(planName) from Eligibility")
	public List<String> getUniquePlanNames();

	@Query("select distinct(planStatus) from Eligibility")
	public List<String> getUniquePlanStatuses();
}
