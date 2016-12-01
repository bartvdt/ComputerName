package computername;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

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
							computerName = (s.hasNext() ? s.next() : "").replaceAll("\n","" );
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
							computerName = (s.hasNext() ? s.next() : "").replaceAll("\n","" );
				        }
						catch(IOException e) {
							System.out.println("Unable to execute: " + command );
					    }		
					}
					break;
	case "Windows": computerName = System.getenv("COMPUTERNAME");
					break;
	case "Unknown":
	default:		computerName = "Unknown";
	}
	
	System.out.println("computerName: " + computerName);
	
	String computerIP = "";
	
	try {
		Enumeration<NetworkInterface> ifaces = NetworkInterface.getNetworkInterfaces();
	    while( ifaces.hasMoreElements() )
	    {
	      NetworkInterface iface = ifaces.nextElement();
	      Enumeration<InetAddress> addresses = iface.getInetAddresses();
	
	      while( addresses.hasMoreElements() )
	      {
	        InetAddress addr = addresses.nextElement();
	        System.out.println("Address: " + addr.toString());
	        if( addr instanceof Inet4Address && !addr.isLoopbackAddress() )
	        {
	        	computerIP = addr.toString();
	        }
	      }
	    }
	} 
	catch(SocketException e)
	{
		System.out.println(e.getMessage());
	}
	
	System.out.println("computerIP: " + computerIP.substring(computerIP.indexOf('/')+1));

}

}
