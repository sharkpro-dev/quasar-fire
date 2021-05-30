package com.quasarFire.businessLogic;

import org.apache.commons.math3.fitting.leastsquares.LeastSquaresOptimizer.Optimum;
import org.apache.commons.math3.fitting.leastsquares.LevenbergMarquardtOptimizer;

import com.lemmingapex.trilateration.NonLinearLeastSquaresSolver;
import com.lemmingapex.trilateration.TrilaterationFunction;
import com.quasarFire.model.Position2D;

public class TrilaterationEstimator {

	public static Position2D estimate(double[][] positions, double[] distances) {
		NonLinearLeastSquaresSolver solver = new NonLinearLeastSquaresSolver(new TrilaterationFunction(positions, distances), new LevenbergMarquardtOptimizer());
		Optimum optimum = solver.solve();
		
		double[] centroid = optimum.getPoint().toArray();
		
		return new Position2D(centroid[0], centroid[1]);
	}
}
