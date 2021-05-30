package com.quasarFire.state.map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigDecimal;
import java.util.Iterator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.quasarFire.model.Satellite;
import com.quasarFire.state.map.exception.SatelliteNotFoundException;

@SpringBootTest
public class SpaceMapTests {
	

	@Autowired
	private SpaceMap map;
	
	@Test
	public void whenGettingUnexistentSatellite_shouldThrowException() {
		assertThatThrownBy(() -> this.map.getSatellite("unexistent")).isInstanceOf(SatelliteNotFoundException.class);
	}
	
	@Test
	public void whenGettingExistentSatellite_shouldReturnItCorrectly() {
		assertThat(this.map.getSatellite("skywalker")).isInstanceOf(Satellite.class);
	}
	
	
	@Test
	public void whenGettingSatelliteCount_shouldReturn3() {
		assertThat(this.map.getSatellitesCount()).isEqualTo(3);
	}
	
	@Test
	public void whenGettingSatellitesCollection_shouldReturnTheCollectionCorrectly() {
		Iterator<Satellite> iterator = this.map.getSatellites().iterator();
		
		assertThat(iterator.next().getName()).isEqualTo("kenobi");
		assertThat(iterator.next().getName()).isEqualTo("sato");
		assertThat(iterator.next().getName()).isEqualTo("skywalker");
	}
}
