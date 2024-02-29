package Day01;

public class Ex9_StringCount {
	private int count;
	private String source = "";
	public Ex9_StringCount(String source)
	{
		this.source = source;
	}
	public int stringCount(String s)
	{
		return stringCount(s, 0);
	}
	public int stringCount(String s, int pos)
	{
		int index = 0;
		if(s == null || s.length() == 0)
		{
			return 0;
		}
		if((index = source.indexOf(s, pos)) != -1)
		{
			count++;
			stringCount(s, index +s.length());
		}
		return count;
	}
	public static void main(String[] args)
	{
		String str = "aaabbccAABBCCaa";
		System.out.println(str);
		Ex9_StringCount sc = new Ex9_StringCount(str);
		System.out.println("aa��" + sc.stringCount("aa") + "�� ã�ҽ��ϴ�.");
		System.out.println(str.contains("aa"));
	}
}
