package com.quasarFire.state;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.quasarFire.state.map.exception.SatelliteNotFoundException;

@SpringBootTest
public class MessageDiscovererTests {

	
	@Autowired
	private MessageDiscoverer messageDiscoverer;

	@Test
	public void whenAddMessageToExistentSatellite_shouldAddCorrectly() {
		this.messageDiscoverer.addMessage("kenobi", Arrays.array("test"));
		assertThat(this.messageDiscoverer.getMessage("kenobi")).isEqualTo(Arrays.array("test"));

	}
	
	@Test
	public void whenAddMessageToUnexistentSatellite_shouldThrowException() {
        assertThatThrownBy(() -> this.messageDiscoverer.addMessage("unexistent", Arrays.array("test"))).isInstanceOf(SatelliteNotFoundException.class);
	}

	@Test
	public void whenAdded3Messages_shouldDiscoverMessageCorrectly() {
		this.messageDiscoverer.addMessage("kenobi", Arrays.array("este", "", "un", ""));
		this.messageDiscoverer.addMessage("skywalker", Arrays.array("", "", "", "mensaje"));
		this.messageDiscoverer.addMessage("sato", Arrays.array("", "es", "", ""));
		
		assertThat(this.messageDiscoverer.discoverMessage()).isEqualTo("este es un mensaje");
	}
}
