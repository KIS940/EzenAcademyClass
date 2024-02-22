package Day06;

public class AutoSaveThread extends Thread{
	public void save()
	{
		System.out.println("작업 내용을");
	}
	@Override
	public void run()
	{
		while(true)
		{
			try
			{
				Thread.sleep(500);
			}
			catch(InterruptedException e)
			{
				break;
			}
			save();
		}
	}
}
