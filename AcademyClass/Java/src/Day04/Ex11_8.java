package Day04;

import java.util.*;

public class Ex11_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer[] arr = { 30, 50, 10, 40, 20};
		
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		Arrays.sort(arr, new DescCompe());
		System.out.println(Arrays.toString(arr));
	}	
}

class DescCompe implements Comparator
{
	public int compare(Object o1, Object o2)
	{
		if(!(o1 instanceof Integer && o2  instanceof Integer))
		{
			return -1;
		}
		Integer i = (Integer)o1;
		Integer i2 = (Integer)o2;
		
		return i.compareTo(12) * -1;
	}
}
