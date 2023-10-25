
public class MyJava {

	public static int sum(int k) {
		if (k > 0) {
			return k+sum(k-1);
		}else {
			return 0;
		}
	}
//	static void checkAge(int age) {
//
//	    
//	    if (age < 18) {
//	      System.out.println("Access denied - You are not old enough!");
//	    } else {
//	      System.out.println("Access granted - You are old enough!");
//	    }
//
//	  }

	public static void main(String[] args) {
		System.out.println(10+20+"java");
		System.out.println("java"+10+20);
		
//		int result = sum(22);
//	    System.out.println(result);
//		String a="bhavana";
//		float b=32E3f;
//		System.out.println(a.length());
//		System.out.println(a.toUpperCase());
//		 System.out.println(a.toLowerCase());
//		System.out.println(a.indexOf("a"));
//		System.out.println(b);
//		//int random=(int)(Math.random()*101);
//		System.out.println((int)(Math.random()*101));
//		 int i = 0;
//	     do  {
//	      System.out.println(i);
//	      i++;
//	    } while (i < 5);
//	     
//	     int[][] num = {{1,2,3,4},{5,6,7,8}};
//	     
//	     
//	     for(int i1=0;i1<num.length;++i1) {
//	    	 for(int j=0;j<num[i1].length;++j) {
//	               System.out.println(num[i1][j]);
//	    	 }
//	     }
//	     checkAge(17);

	}
}
