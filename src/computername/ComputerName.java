package computername;

import computername.LinuxName;
import computername.MacOSName;
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
	
	String computerName = "";
	
	if (os.indexOf("mac") >= 0)
		os = "MacOS";
	else if (os.indexOf("nux") >= 0)
		os = "Linux";
	else if (os.indexOf("win") >= 0)
		os = "Windows";
	else
		os = "Unknown";
	
	switch (os) {
	case "MacOS":	MacOSName mn = new MacOSName();
					computerName = mn.getComputerName();
					break;
	case "Linux": 	LinuxName ln = new LinuxName(); 
					computerName = ln.getComputerName();
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
