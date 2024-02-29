package Day06;

public class SafeStopEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintThread printThread = new PrintThread();
		printThread.start();
		try {
			Thread.sleep(500);
		}catch(InterruptedException e) {}
		printThread.setStop(true);
	}

}
