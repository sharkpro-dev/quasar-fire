package com.quasarFire.controller.model;

import java.math.BigDecimal;

public class SatelliteBody {
	private String name;
	private BigDecimal distance;
	private String[] message;

	
	public String getName() {
		return name;
	}
	public BigDecimal getDistance() {
		return distance;
	}
	public String[] getMessage() {
		return message;
	}	
}
