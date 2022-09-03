package com.cg.flightmgmt.repository;

import java.math.BigInteger;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cg.flightmgmt.dto.Airport;
import com.cg.flightmgmt.dto.Flight;

public interface AirportRepository extends JpaRepository<Airport, Integer> {
	/*
	 * Getting the all the Airport with the help of @Query
	 */
	@Query(value="Select * from Airport",nativeQuery=true)
	public List<Airport> viewAirport();

	/*
	 * Getting the airport from Airport with the help of airportcode with the help of @Query
	 */
	@Query(" select a from Airport a WHERE a.airportCode=:aCd ")
	public Airport getAirportByCode(int aCd);


}
