package com.valtech.training.spring;

public class ArithmeticImpl implements Arithmetic{
	

	public ArithmeticImpl() {
	}

	@Override
	public int add(int a, int b) {
		
		return a+b;
	}

	@Override
	public int sub(int a, int b) {
		return a-b;
	}

	@Override
	public int div(int a, int b) throws DivideByZeroException {
		if(b==0) {
			throw new DivideByZeroException("zero cannot be used as Denominator");
		}
		return a/b;
	}

	@Override
	public int mul(int a, int b) {
		
		return a*b;
	}
public static void main(String[] args)   {
	ArithmeticImpl a =new ArithmeticImpl();
	
	System.out.println(a.add(2, 3));
	try {
		System.out.println(a.div(2, 1));
		System.out.println("not seen");
	} catch (DivideByZeroException e) {
		System.out.println(e.getLocalizedMessage());
	}catch(Exception e) {
		System.out.println("will be seen");
	}finally {
		System.out.println("seen always");
	}
	System.out.println(a.mul(4, 2));
	
	
}
}
