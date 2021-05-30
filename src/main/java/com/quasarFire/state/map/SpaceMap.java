package com.quasarFire.state.map;

import java.util.Collection;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.quasarFire.model.Satellite;
import com.quasarFire.state.map.exception.SatelliteNotFoundException;

@Component
public class SpaceMap {
	
	private Map<String, Satellite> satellitesByName;
	
	@PostConstruct
	public void initialize() {
	   this.satellitesByName = QuasarFireMapInitializer.makeSatellites();
	}

	public Satellite getSatellite(String name) {
		if(!this.satellitesByName.containsKey(name)) {
			throw new SatelliteNotFoundException("Satelite inexistente: " + name);
		}
		
		return this.satellitesByName.get(name.toLowerCase());
	}
	
	public Collection<Satellite> getSatellites(){		
		return this.satellitesByName.values();
	}
	
	public Integer getSatellitesCount() {
		return this.satellitesByName.size();
	}
	
}
