package computername;

import java.io.InputStream;
import java.io.IOException;
import java.util.Scanner;

public class LinuxName {

	public String getComputerName()
	{
		String computerName = "TBD";

		String command = "cat /etc/hostname";
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
