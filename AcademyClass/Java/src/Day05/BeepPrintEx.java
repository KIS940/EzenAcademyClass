package Day05;

import java.awt.Toolkit;

public class BeepPrintEx {

	public static void main(String[] args) {
//		for(int i = 0; i < 5; i++)
//		{
//			System.out.println("ABCDEFG");
//			try{Thread.sleep(1000);} catch(Exception e) {}
//		}
//		
//		for(int i = 0; i < 5; i++)
//		{
//			System.out.println("띵");
//			try {Thread.sleep(1000);} catch(Exception e) {}
//		}
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				for(int i = 0; i < 5; i++)
				{
					toolkit.beep();
					try{Thread.sleep(1000);} catch(Exception e) {}
				}
			}
		});
		thread.start();
		
		for(int i =0; i < 5; i++)
		{
			System.out.println("띵");
			try {Thread.sleep(1000);} catch(Exception e) {}
		}
	}
}
