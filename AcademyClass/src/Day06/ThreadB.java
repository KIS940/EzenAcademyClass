package Day06;

public class ThreadB extends Thread{
	private WorkObject workObject;
	public ThreadB(WorkObject workObject)
	{
		setName("ThreadB");
		this.workObject = workObject;
	}
	@Override
	public void run()
	{
		for(int i = 0; i < 3; i++)
		{
			workObject.methodB();
		}
	}
}
