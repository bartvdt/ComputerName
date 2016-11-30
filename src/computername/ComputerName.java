package computername;

import computername.LinuxName;

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
	
	switch (os) {
	case "linux": 	LinuxName ln = new LinuxName(); 
					computerName = ln.getComputerName();
					break;
	
	}
	
	System.out.println("computername: " + computerName);
}

}
