package com.quasarFire.businessLogic.exception;

public class IncompleteMessageException extends RuntimeException {

	private static final long serialVersionUID = 5631137033240005191L;

	public IncompleteMessageException(String errorMessage) {
		super(errorMessage);
	}
}
