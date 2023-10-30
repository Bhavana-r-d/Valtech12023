package com.valtech.training.day2;

import java.awt.Point;

public class PointImpl implements DistanceCalculation {

	@Override
	public double distance(Point a, Point b) {
		double X=a.getX()-b.getX();
		double Y=a.getY()-b.getY();
		return Math.sqrt(X*X+Y*Y);
	}
}
