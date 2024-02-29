package Day01;

import java.util.StringTokenizer;

public class StringTokenizerEx3 {

	public static void main(String[] args) {
		String source = "1,김친재,100,100,100|2,박수재,95,80,90|3,이자바,80,90,90";
		StringTokenizer st = new StringTokenizer(source, "|");
		
		while(st.hasMoreTokens())
		{
			String token = st.nextToken();
			StringTokenizer st2 = new StringTokenizer(token, ",");
			while(st2.hasMoreTokens())
				System.out.println(st2.nextToken());
			System.out.println("===========");
		}
	}

}