package Day06;

public class WaitNotifyEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WorkObject workObject = new WorkObject();
		ThreadA threadA = new ThreadA(workObject);
		ThreadB threadB = new ThreadB(workObject);
		
		threadA.start();
		threadB.start();
		
	}

}
