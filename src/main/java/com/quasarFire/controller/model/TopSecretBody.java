package com.quasarFire.controller.model;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;


public class TopSecretBody {

	private List<SatelliteBody> satellites;

	public List<SatelliteBody> getSatellites() {
		return satellites;
	}

	public BigDecimal[] getDistancesOrderedByName() {
		BigDecimal[] distances = new BigDecimal[satellites.size()];

		satellites.sort(new Comparator<SatelliteBody>() {

			@Override
			public int compare(SatelliteBody a, SatelliteBody b) {
				return a.getName().compareTo(b.getName());
			}
		
		});
		
		for (int i = 0 ; i < satellites.size(); i++ ) {
			distances[i] = satellites.get(i).getDistance();
		}

		return distances;
	}


	public String[][] getMessages() {
		String[][] messages = new String[satellites.size()][getMessagesSize()];

		for (int sentence = 0 ; sentence < satellites.size(); sentence++ ) {
			for (int word = 0 ; word < getMessagesSize(); word++ ) {
				messages[sentence][word] = this.satellites.get(sentence).getMessage()[word];
			}
		}

		return messages;
	}

	private Integer getMessagesSize() {
		if(this.satellites.isEmpty())
			return 0;
		
		return this.satellites.get(0).getMessage().length;
	}

}
