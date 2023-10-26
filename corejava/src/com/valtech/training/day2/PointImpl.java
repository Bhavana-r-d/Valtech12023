package com.valtech.training.day2;

import com.valtech.training.day1.Point;

public class PointImpl implements DistanceCalculation {


//	public PointImpl(Arithmetic arithmetic) {
//		
//	}
//	@Override
//	public DistanceCalculation add( DistanceCalculation a,  DistanceCalculation b) {
//		return a + b;
//	}
//
//	@Override
//	public double sub(double a, double b) {
//		return a - b;
//	}
//
//	@Override
//	public double distance(double a1, double b1, double a2, double b2) {
//		double r1 = a2 - a1;
//		double r2 = b2 - b1;
//		return Math.sqrt(r1 * r1 + r2 * r2);
//	}


//public static void main(String[] args) {
//		 Arithmetic  arithmetic= new  ArithmeticImpl();
//		 DistanceCalculation  si= new PointImpl(arithmetic);
//		 System.out.println(si.add(2,3));
//		 System.out.println(si.sub(4,3));
//		 System.out.println(si.distance( 2,3,4,3));
//
//
//}
@Override
public Point add(Point a, Point b) {
	return a + b;
	}
@Override
public Point sub(Point a, Point b) {
	return a - b;
	}
@Override
public double distance(double a1, double b1) {
	// TODO Auto-generated method stub
	return 0;
}


}
