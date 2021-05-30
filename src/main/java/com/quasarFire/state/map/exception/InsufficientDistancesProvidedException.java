package com.quasarFire.state.map.exception;

public class InsufficientDistancesProvidedException extends RuntimeException{
	private static final long serialVersionUID = 5631137033240005191L;

	public InsufficientDistancesProvidedException(String errorMessage) {
		super(errorMessage);
	}
}
