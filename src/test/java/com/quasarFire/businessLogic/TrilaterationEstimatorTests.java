package com.quasarFire.businessLogic;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.quasarFire.model.Position2D;

@SpringBootTest
public class TrilaterationEstimatorTests {

	@Test
	public void whenPassedTwoPositions_shouldCalculateCorrectly() {
		double[][] positions = { { 1.0, 0.0 }, { -3.0, 0.0 } };
		double[] distances = { 2.0, 2.0 };

		Position2D position = TrilaterationEstimator.estimate(positions, distances);
		assertThat(position.getX()).isEqualTo(BigDecimal.ONE.negate());
		assertThat(position.getY()).isEqualTo(BigDecimal.ZERO);

	}

	@Test
	public void whenPassedThreePositions_shouldCalculateCorrectly() {
		double[][] positions = { { 1.0, 1.0 }, { 3.0, 1.0 }, { 2.0, 2.0 } };
		double[] distances = { 1.0, 1.0, 1.0 };

		Position2D position = TrilaterationEstimator.estimate(positions, distances);
		assertThat(position.getX()).isEqualTo(new BigDecimal(2));
		assertThat(position.getY()).isEqualTo(BigDecimal.ONE);

	}

}
