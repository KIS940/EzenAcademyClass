package Day08;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteEx2 {

	public static void main(String[] args) {
		try
		{
			OutputStream os = new FileOutputStream("D:/Temp/test2.db");
			
			byte[] a = {10, 20, 30, 40};
			
			os.write(a);
			
			os.flush();
			os.close();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
