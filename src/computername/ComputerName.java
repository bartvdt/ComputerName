package computername;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import computername.WindowsName;

public class ComputerName {

public static void main(String[] args) {
	// TODO Auto-generated method stub
	
	System.out.println("Main");
	
	String logString="";
	for (int i=0; i<args.length; i++)
		logString=logString+ " " + args[i];
		
	
	String os = System.getProperty("os.name").toLowerCase();

	System.out.println("os: " + os);
	
	
	if (os.indexOf("mac") >= 0)
		os = "MacOS";
	else if (os.indexOf("nux") >= 0)
		os = "Linux";
	else if (os.indexOf("win") >= 0)
		os = "Windows";
	else
		os = "Unknown";
	
	String command;
	String computerName = "";
	
	switch (os) {
	case "MacOS":	{
						command = "/usr/sbin/scutil --get ComputerName";
						try {
							Process proc = Runtime.getRuntime().exec(command);
							InputStream stream = proc.getInputStream();
							Scanner s = new Scanner(stream).useDelimiter("\\A");
							computerName = s.hasNext() ? s.next() : "";
				        }
						catch(IOException e) {
							System.out.println("Unable to execute: " + command );
					    }			
					}
					break;
	case "Linux": 	{
						command = "cat /etc/hostname";
						try {
							Process proc = Runtime.getRuntime().exec(command);
							InputStream stream = proc.getInputStream();
							Scanner s = new Scanner(stream).useDelimiter("\\A");
							computerName = s.hasNext() ? s.next() : "";
				        }
						catch(IOException e) {
							System.out.println("Unable to execute: " + command );
					    }		
					}
					break;
	case "Windows": WindowsName wn = new WindowsName();
					computerName = wn.getComputerName();
					break;
	case "Unknown":
	default:		computerName = "Unknown";
	}
	
	System.out.println("computername: " + computerName);
}

}
