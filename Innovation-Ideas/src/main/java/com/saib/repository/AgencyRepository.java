package com.saib.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saib.models.Agencies;

@Repository
public interface AgencyRepository extends JpaRepository<Agencies,Long> {

	
	
}