package Final;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Logger {

	private static String path;
	public static void setPath(String path)
	{
		Logger.path = path;
	}
	
	public synchronized static void LogMessage(String message)
	{
		File file = new File(path);
		try (PrintWriter pw = new PrintWriter(new FileWriter(file, true)))
		{
			pw.println(message);
			pw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
