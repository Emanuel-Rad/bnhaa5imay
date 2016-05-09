package station3;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import model.Package;
import station2.Station2Interface;

public class Station3Controller {
	private static Station2Interface server;
	
	public Station3Controller() {
		Registry registry;
		try {
			registry = LocateRegistry.getRegistry();
			server = (Station2Interface) registry.lookup("Station2");
		} catch (RemoteException | NotBoundException e) {
			e.printStackTrace();
		}		
	}

	public ArrayList<Package> getHalfPackages(int n) {
		try {
			return server.getHalfPackages(n);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Package> getPartPackages(String type, int n) {
		try {
			return server.getPartPackages(type, n);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void markAsContaminated(String label) {
		try {
			server.markAsContaminated(label);
		} catch (RemoteException e) {
			e.printStackTrace();
		}	
	}
}
