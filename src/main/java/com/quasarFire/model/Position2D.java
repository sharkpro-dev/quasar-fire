package com.quasarFire.model;

import java.math.BigDecimal;

public class Position2D {
	
	private BigDecimal x;
	private BigDecimal y;
	
	public Position2D(BigDecimal x, BigDecimal y) {
		this.x = x;
		this.y = y ;
	}
	
	public Position2D(double x, double y) {
		this.x = new BigDecimal(x);
		this.y = new BigDecimal(y) ;
	}
	
	
	public Position2D(Integer x, Integer y) {
		this.x = new BigDecimal(x);
		this.y = new BigDecimal(y) ;
	}

	public BigDecimal getX() {
		return x;
	}

	public BigDecimal getY() {
		return y;
	}

	public double[] toDoubleArray() {
		double[] position = {x.doubleValue(), y.doubleValue()};
		return position;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final Position2D other = (Position2D) obj;
      

        return this.getX().equals(other.getX()) && this.getY().equals(other.getY());
	}

}
