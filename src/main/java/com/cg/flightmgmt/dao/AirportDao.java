package com.cg.flightmgmt.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.flightmgmt.dto.Airport;
import com.cg.flightmgmt.dto.Flight;
import com.cg.flightmgmt.exception.AirportNotFoundException;
import com.cg.flightmgmt.exception.FlightNotFoundException;
import com.cg.flightmgmt.repository.AirportRepository;
import com.cg.flightmgmt.service.AirportService;

/*
 * Using implements keyword to access the service interface
 * Using @Service annotation to perform the service interface tasks 
 * Overriding all the methods from IStatementService
*/
@Service
public class AirportDao implements AirportService{
	/*
	 Autowired annotation is used for automatic dependency injection
	 */
	@Autowired
	private AirportRepository repo;
	
	
	@Override
	/*
	 * Here we are using addAirport method to add new Airportto the database
	 */
	public Airport addAirport(Airport airport) {
		return repo.save(airport);
	}
	
	@Override
	/*
	 * Here we are using ViewAirport method to view All airport  from the database
	 * Here we recieve the data in the form of list
	 */
	public List<Airport> viewAirport(){
		return repo.findAll();
	}
	
	@Override
	/*
	 * Here we are using ViewAirport method to view Airport based on airport code from the database
	 */
    public Airport viewAirport(int airportCode) throws AirportNotFoundException{
		Airport airport = repo.getAirportByCode(airportCode);
		if(airport!=null)
		{
			return airport;
		}
		else {
			throw new AirportNotFoundException("Airport not found");
		}
	}
}
