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

// rmi client to main server
// coverter Model-Json
public class Station3Controller {
	
	private static Station2Interface server;
	private ObjectMapper json;

	public Station3Controller() throws RemoteException, NotBoundException {
		Registry registry;
		registry = LocateRegistry.getRegistry();
		server = (Station2Interface) registry.lookup("Station2");
		json = new ObjectMapper();
	}

	public String getMixPackages(String shop, int n) throws RemoteException {
		ArrayList<Package> packages = server.getMixPackages(shop, n);
		String jsonPackages = toJson(packages);
		return jsonPackages;
	}

	public String getPartPackages(String shop, char type, int n) throws RemoteException {
		ArrayList<Package> packages = server.getPartPackages(shop, type, n); 
		String jsonPackages = toJson(packages);
		return jsonPackages;
	}

	public void markAsContaminated(String label) throws RemoteException {
		server.markAsContaminated(label);
	}
	
	private String toJson(ArrayList<Package> packages) {
		try {
			return json.writerWithDefaultPrettyPrinter().writeValueAsString(packages);			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
}

