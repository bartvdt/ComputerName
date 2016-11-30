package computername;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class MacOSName {

		public String getComputerName()
		{
			String computerName = "TBD";

			String command = "/usr/sbin/scutil --get ComputerName";
			try {
				Process proc = Runtime.getRuntime().exec(command);
				InputStream stream = proc.getInputStream();
				Scanner s = new Scanner(stream).useDelimiter("\\A");
				computerName = s.hasNext() ? s.next() : "";
		        }
			catch(IOException e)
		        {
		        System.out.println("Unable to execute: " + command );
		        }
			
		    return computerName;
		}
}
