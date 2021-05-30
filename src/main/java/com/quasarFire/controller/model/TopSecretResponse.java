package com.quasarFire.controller.model;

import com.quasarFire.model.Position2D;

public class TopSecretResponse {
	
	public Position2D position;
	
	public String message;

	public TopSecretResponse(Position2D position, String message) {
		super();
		this.position = position;
		this.message = message;
	}
}
