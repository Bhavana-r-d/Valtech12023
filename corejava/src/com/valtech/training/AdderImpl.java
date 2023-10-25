package com.valtech.training;

public class AdderImpl implements Adder {
	@Override
	public int add(int a, int b) {

		return a + b;
	}

	public static void main(String[] args) {
		Adder a = new AdderImpl();
		System.out.println(a.add(2, 3));
		Adder a1 = new Adder() {
			@Override
			public int add(int a, int b) {

				return a + b;
			}

		};

		// lamda Expression
		Adder a2 = (i, j) -> {
			return i + j;
		};
		System.out.println("result of lamda expression:"+a2.add(3, 4));

	}

}
