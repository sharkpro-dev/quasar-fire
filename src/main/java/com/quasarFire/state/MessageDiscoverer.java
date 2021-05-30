package com.quasarFire.state;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.quasarFire.businessLogic.MessageFragmentJoiner;
import com.quasarFire.model.Satellite;
import com.quasarFire.state.map.SpaceMap;

@Component
public class MessageDiscoverer {
	
	@Autowired
	private SpaceMap map;

	private Map<Satellite,String[]> messagesBySatellite = new ConcurrentHashMap<Satellite, String[]>();
	
	@PostConstruct
	public void initialize() {
	   this.messagesBySatellite = new ConcurrentHashMap<Satellite, String[]>();
	}
	
	
	public void addMessage(String name, String[] message ) {
		this.messagesBySatellite.put(this.map.getSatellite(name), message);
	}	
	
	public String[] getMessage(String name) {
		return this.messagesBySatellite.get(this.map.getSatellite(name));
	}
	
	public String discoverMessage() {
		synchronized (messagesBySatellite) {			
			String[][] messages = this.messagesBySatellite.values().stream().toArray(String[][]::new);
			return MessageFragmentJoiner.join(messages);	
		}
	}
}
