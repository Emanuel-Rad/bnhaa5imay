package station3;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.Package;
import station2.Station2Interface;

public class Station3Controller {
	private static Station2Interface server;
	private ObjectMapper json;

	public Station3Controller() throws RemoteException, NotBoundException {
		Registry registry;
		registry = LocateRegistry.getRegistry();
		server = (Station2Interface) registry.lookup("Station2");
		json = new ObjectMapper();
	}

	public String getHalfPackages(int n) throws RemoteException {
		ArrayList<Package> packages = server.getHalfPackages(n);
		return toString(packages);
	}

	public String getPartPackages(String type, int n) throws RemoteException {
		ArrayList<Package> packages = server.getPartPackages(type, n); 
		return toString(packages);
	}

	public void markAsContaminated(String label) throws RemoteException {
		server.markAsContaminated(label);
	}
	
	private String toString(ArrayList<Package> packages) {
		String s = null;
		try {
			s = json.writerWithDefaultPrettyPrinter().writeValueAsString(packages);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return s;
	}
}

