package Day04;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Ex11_10A {

	public static void main(String[] args) {
		Set hset = new HashSet();
		Set tset = new TreeSet();
		
		for(int i = 0; hset.size() < 6; i++)
		{
			int num = (int) (Math.random()*45) + 1;
			hset.add(new Integer(num));
		}
		for(int i =0; tset.size() < 6; i++)
		{
			int num = (int) (Math.random()*45) + 1;
			tset.add(new Integer(num));
		}
		System.out.println(hset);
		System.out.println(tset);
		List list = new LinkedList(hset);
		Collections.sort(list);
		System.out.println(list);
	}

}
