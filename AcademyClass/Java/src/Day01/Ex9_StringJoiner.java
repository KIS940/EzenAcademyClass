package Day01;
import java.util.StringJoiner;
public class Ex9_StringJoiner {

	public static void main(String[] args) {
		String animals = "dog, cat, bear";
		String[] arr = animals.split(",");
		String str = String.join("-",arr);
		System.out.println(str);
		
		StringJoiner sj = new StringJoiner(":","[","]");
		sj.add("George").add("Sally").add("Fred");
		String desiredString = sj.toString();
		System.out.println(desiredString);
		int iVal = 100;
		String strVal = String.valueOf(iVal);
		double dVal = 200.0;
		String strVal2 = dVal + "";
		double sum = Integer.parseInt("+" + strVal) + Double.parseDouble(strVal2);
		double sum2 = Integer.valueOf(strVal) + Double.valueOf(strVal2);
		System.out.println(String.join("",strVal,"+",strVal2,"=") +sum);
		System.out.println(strVal + "+" + strVal2 + "=" + sum2);
	}

}
