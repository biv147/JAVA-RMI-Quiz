//package Server;

import java.io.*;
import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.UnicastRemoteObject;


public class FileServer {
	public static void main(String argv[]) {
		if(System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		
		System.out.println("Server is running.....");

		try {
			String name = "FileServer";
			FileInterface file = new FileImpl(name);
			FileInterface stub = (FileInterface) UnicastRemoteObject.exportObject(file,0);
			Registry registry = LocateRegistry.getRegistry();
			registry.rebind(name,stub);
			System.out.println("File server bound in registry!");
			
		} catch(Exception e) {
			System.out.println("FileServer: "+e.getMessage());
		 	e.printStackTrace();
		 	
		}
	}
}