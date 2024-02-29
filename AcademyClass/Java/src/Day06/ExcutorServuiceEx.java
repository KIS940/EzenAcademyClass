package Day06;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExcutorServuiceEx {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		
		executorService.shutdownNow();
	}

}
