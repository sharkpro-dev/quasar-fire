package com.quasarFire.businessLogic.service;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quasarFire.businessLogic.MessageFragmentJoiner;
import com.quasarFire.controller.model.SatelliteBody;
import com.quasarFire.model.Position2D;
import com.quasarFire.model.Satellite;
import com.quasarFire.state.MessageDiscoverer;
import com.quasarFire.state.SpaceShipRadar;
import com.quasarFire.state.map.SpaceMap;


@Service
public class TopSecretMessagesService {

	@Autowired
	private SpaceShipRadar radar;
	
	@Autowired
	private SpaceMap map;
	
	@Autowired
	private MessageDiscoverer messagesCollector;
	
	
	public Position2D getLocation(BigDecimal... distances) {
		Iterator<Satellite> satellitesIterator = this.map.getSatellites().iterator();
		
		for( int idx = 0; satellitesIterator.hasNext() && idx < distances.length ; idx++ ) {
			Satellite satellite = satellitesIterator.next();
			this.radar.addDistance(satellite.getName(), distances[idx]);
		}
		
		return this.radar.trilaterationEstimation();
	}
	
	public String getMessage(String[]... messages) {
		return MessageFragmentJoiner.join(messages);
	}
	
	
	public Position2D getLocationFromStoredData() {
		return this.radar.trilaterationEstimation();
	}
	
	public String getMessageFromStoredData() {
		return this.messagesCollector.discoverMessage();
	}

	public void storeSatellitesData(List<SatelliteBody> satellites) {
		for(SatelliteBody satelliteBody: satellites) {
			this.radar.addDistance(satelliteBody.getName(), satelliteBody.getDistance());
			this.messagesCollector.addMessage(satelliteBody.getName(), satelliteBody.getMessage());
		}
		
	}
	

}
