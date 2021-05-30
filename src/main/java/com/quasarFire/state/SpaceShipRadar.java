package com.quasarFire.state;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.quasarFire.businessLogic.TrilaterationEstimator;
import com.quasarFire.model.Position2D;
import com.quasarFire.model.Satellite;
import com.quasarFire.state.map.SpaceMap;
import com.quasarFire.state.map.exception.InsufficientDistancesProvidedException;

@Component
public class SpaceShipRadar {
	
	@Autowired
	private SpaceMap map;
	
	private Map<Satellite, BigDecimal> distancesBySatellite;
	
	@PostConstruct
	public void initialize() {
	   this.distancesBySatellite = new ConcurrentHashMap<Satellite, BigDecimal>();
	}

	public void addDistance(String name, BigDecimal distance ) {
		if(distance.compareTo(BigDecimal.ZERO) < 0 ) {
			throw new IllegalArgumentException("Debe ingresar una distancia mayor a cero.");
		}
		
		this.distancesBySatellite.put(this.map.getSatellite(name), distance);
	}	
	
	public BigDecimal getDistance(String name) {
		return this.distancesBySatellite.get(this.map.getSatellite(name));
	}
	
	public Position2D trilaterationEstimation() {
		synchronized (distancesBySatellite) {
			if(!map.getSatellitesCount().equals(distancesBySatellite.size())) {
				throw new InsufficientDistancesProvidedException("No hay distancias para todos los satelites.");
			}
			
			
			double[] distances = new double[this.distancesBySatellite.size()];
			double[][] positions = new double[this.distancesBySatellite.size()][2];
			
			Iterator<Satellite> satellitesIterator = this.map.getSatellites().iterator();
			for( int idx = 0; satellitesIterator.hasNext(); idx++ ) {
				Satellite satellite = satellitesIterator.next();
				
				distances[idx] = this.getDistance(satellite.getName()).doubleValue();
				positions[idx] = satellite.getPosition().toDoubleArray();
			}			
			return TrilaterationEstimator.estimate(positions, distances);
		}
	}
	
}
