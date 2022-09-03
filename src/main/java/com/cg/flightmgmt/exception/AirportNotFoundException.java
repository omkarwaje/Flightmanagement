package com.cg.flightmgmt.exception;
/*
 * In this class we are creating an ExceptionHandler. It extends
 * to the super class of Exception and check for Exception and throw manual message to the user using String error message.
*/
public class AirportNotFoundException extends Exception{
	public AirportNotFoundException(String str) {
		super(str);
	}
}
