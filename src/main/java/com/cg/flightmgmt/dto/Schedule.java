package com.cg.flightmgmt.dto;

import java.math.BigInteger;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/*
 * With the help of @Entity annotation we are making this class as an entity
 * and mapping it to a database table
 * Providing the table name with the help of @Table(name="")*/
@Entity
@Table(name="Schedule_table")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class Schedule {
	@Id
	@NotNull(message="Schedule Id should not be null")
	private BigInteger scheduleId;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "source_airportCode")
	private Airport sourceAirport;
	/*
	 * JPA allows you to define One-to-one relationships between entity classes
	 * using the @OneToOne annotation
	 */
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "destination_airportCode")
	private Airport destinationAirport;
	@NotNull(message="Departure Time should not be null")
	@Column(name = "departuretime")
	private LocalDateTime departureTime;
	@NotNull(message="Arrival Time should not be null")
	@Column(name = "arrivalTime")
	private LocalDateTime arrivalTime;
	
	public Schedule() {
		super();
	}
	/*
	 * Adding getters and setters for retrieving and updating the values.
	 */
	public Schedule(BigInteger scheduleId, Airport sourceAirport, Airport destinationAirport, LocalDateTime arrivalTime,
			LocalDateTime departureTime) {
		super();
		this.scheduleId = scheduleId;
		this.sourceAirport = sourceAirport;
		this.destinationAirport = destinationAirport;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
	}
	public BigInteger getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(BigInteger scheduleId) {
		this.scheduleId = scheduleId;
	}
	public Airport getSourceAirport() {
		return sourceAirport;
	}
	public void setSourceAirport(Airport sourceAirport) {
		this.sourceAirport = sourceAirport;
	}
	public Airport getDestinationAirport() {
		return destinationAirport;
	}
	public void setDestinationAirport(Airport destinationAirport) {
		this.destinationAirport = destinationAirport;
	}
	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public LocalDateTime getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}

	@Override
	public String toString() {
		return "Schedule [scheduleId=" + scheduleId + ", sourceAirport=" + sourceAirport + ", destinationAirport="
				+ destinationAirport + ", arrivalTime=" + arrivalTime + ", departureTime=" + departureTime + "]";
	}
}
