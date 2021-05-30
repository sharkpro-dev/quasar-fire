package com.quasarFire.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quasarFire.businessLogic.service.TopSecretMessagesService;
import com.quasarFire.controller.model.TopSecretBody;
import com.quasarFire.controller.model.TopSecretResponse;
import com.quasarFire.model.Position2D;

@RestController
class TopSecretMessagesController {

	@Autowired
	private TopSecretMessagesService topSecretMessagesService;

	@PostMapping(value = "/topsecret", consumes = { MediaType.APPLICATION_JSON_VALUE} )
	TopSecretResponse traceSenderAndDiscoverMessage(@RequestBody TopSecretBody topSecretBody) {
		Position2D position = this.topSecretMessagesService.getLocation(topSecretBody.getDistancesOrderedByName());
		String message = this.topSecretMessagesService.getMessage(topSecretBody.getMessages());
		
		return new TopSecretResponse(position, message);
	}
	
	@PostMapping(value = "/topsecret_split", consumes = { MediaType.APPLICATION_JSON_VALUE} )
	void storeDistancesAndMessageFragments(@RequestBody TopSecretBody topSecretBody) {
		this.topSecretMessagesService.storeSatellitesData(topSecretBody.getSatellites());
	}
	
	@GetMapping("/topsecret_split")
	TopSecretResponse tryToFindShipAndDiscoverMessage() {
		Position2D position = this.topSecretMessagesService.getLocationFromStoredData();
		String message = this.topSecretMessagesService.getMessageFromStoredData();
		
		return new TopSecretResponse(position, message);
	}

}