package com.quasarFire.state.map.exception;

public class SatelliteNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 5631137033240005191L;

	public SatelliteNotFoundException(String errorMessage) {
		super(errorMessage);
	}
	
}
