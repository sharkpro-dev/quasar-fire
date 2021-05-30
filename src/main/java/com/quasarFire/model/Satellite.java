package com.quasarFire.model;

public class Satellite {
	
	private String name;
	private Position2D position;
	
	public Satellite(String name, Position2D position) {
		super();
		this.name = name;
		this.position = position;
	}
	
	public String getName() {
		return name;
	}

	public Position2D getPosition() {
		return position;
	}

	
}
