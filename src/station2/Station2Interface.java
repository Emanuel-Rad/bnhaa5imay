package station2;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import model.Package;

public interface Station2Interface extends Remote {
	ArrayList<Package> getHalfPackages(int n) throws RemoteException;
	ArrayList<Package> getPartPackages(String type, int n) throws RemoteException;
	void markAsContaminated(String label) throws RemoteException;
}
