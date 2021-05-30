package com.quasarFire.state.map;

import java.util.Map;
import java.util.TreeMap;

import com.quasarFire.model.Position2D;
import com.quasarFire.model.Satellite;

public class QuasarFireMapInitializer {
	
	private static final String[] NAMES = {"kenobi", "skywalker", "sato"};
	private static final Position2D[] POSITIONS = {new Position2D(-500, -200), new Position2D(100, -100), new Position2D(500, 100)};
	
	
	public static Map<String, Satellite> makeSatellites(){
		Map<String, Satellite> satellites = new TreeMap<String, Satellite>();
		
		for(int i = 0; i < NAMES.length; i++) {
			satellites.put(NAMES[i],new Satellite(NAMES[i], POSITIONS[i]));
		}
		
		return satellites;
	}
}
