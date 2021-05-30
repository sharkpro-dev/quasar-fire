package com.quasarFire.state;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.quasarFire.model.Position2D;
import com.quasarFire.state.map.exception.SatelliteNotFoundException;

@SpringBootTest
public class SpaceShipRadarTests {

	@Autowired
	private SpaceShipRadar radar;

	@Test
	public void whenAddDistanceToExistentSatellite_shouldAddCorrectly() {
		this.radar.addDistance("kenobi", BigDecimal.ONE);

		assertThat(this.radar.getDistance("kenobi")).isEqualTo(BigDecimal.ONE);

	}
	
	@Test
	public void whenAddDistanceLowerThanZero_shouldThrowException() {
		assertThatThrownBy(() -> this.radar.addDistance("kenobi", BigDecimal.ONE.negate())).isInstanceOf(IllegalArgumentException.class);

	}
	
	@Test
	public void whenAddDistanceToUnexistentSatellite_shouldThrowException() {
        assertThatThrownBy(() -> this.radar.addDistance("unexistent", BigDecimal.ONE)).isInstanceOf(SatelliteNotFoundException.class);
	}
	

	@Test
	public void whenAdded3Distances_shouldCalculateEstimatedCorrectly() {
		this.radar.addDistance("kenobi", new BigDecimal(Math.sqrt(340000)));
		this.radar.addDistance("skywalker", new BigDecimal(Math.sqrt(50000)));
		this.radar.addDistance("sato", new BigDecimal(Math.sqrt(250000)));
		
		Position2D position = this.radar.trilaterationEstimation();
		
		assertThat(position.getX()).isBetween(BigDecimal.ONE.negate(), BigDecimal.ONE);
		assertThat(position.getY()).isBetween(new BigDecimal(99), new BigDecimal(101));
	}
	

}
