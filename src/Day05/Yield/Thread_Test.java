package Day05.Yield;

class ThreadA extends Thread
{
	private boolean stop = false;
	private boolean flag = true;
	
	public void setFlag(boolean flag)
	{
		this.flag = flag;
	}
	public void setStop(boolean stop)
	{
		this.stop = stop;
	}
	
	public void run()
	{
		while(!stop)
		{
			if(flag)
			{
				System.out.println("ThreadA is working..");
			}
			else
			{
				Thread.yield();
			}
		}
	}
}

class ThreadB extends Thread
{
	private boolean stop = false;
	private boolean flag = true;
	
	public void setFlag(boolean flag)
	{
		this.flag = flag;
	}
	public void setStop(boolean stop)
	{
		this.stop = stop;
	}
	
	public void run()
	{
		while(!stop)
		{
			if(flag)
			{
				System.out.println("ThreadB is working..");
			}
			else
			{
				Thread.yield();
			}
		}
	}
}


public class Thread_Test {

	public static void main(String[] args) {
		ThreadA threadA = new ThreadA();
		ThreadB threadB = new ThreadB();
		
		threadA.start();
		threadB.start();
		
		try
		{
			Thread.sleep(500);
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		
		threadA.setFlag(false);
		try
		{
			Thread.sleep(500);
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		threadA.setFlag(true);
		threadB.setFlag(false);
		try
		{
			Thread.sleep(500);
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		threadA.setStop(true);
		threadB.setStop(true);
	}

}
