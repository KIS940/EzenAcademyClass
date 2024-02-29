package Day01;

public class CircleEx {
	public static void main(String[] args) throws ClassNotFoundException {
		Circle c1 = new Circle();
		Circle c2 = new Circle();
		
		Class cobj = c1.getClass();
		Class cobj2 = Circle.class;
		Class cobj3 = Class.forName("Day14.Circle");
		
		int a = 100;
		Double sa = Double.valueOf(a);
		System.out.println(sa);
		double b = 200.0;
		String sb = b + "";
		
//		double sum = Integer.valueOf(sa) + Double.valueOf(sb);
//		System.out.println(sum);
		
	}
}
