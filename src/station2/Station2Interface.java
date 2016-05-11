package station2;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import model.Package;
import model.Pork;

public interface Station2Interface extends Remote {
	void receivePigs(ArrayList<Pork> porks) throws RemoteException;
	ArrayList<Package> getMixPackages(String shop, int n) throws RemoteException;
	ArrayList<Package> getPartPackages(String shop, char type, int n) throws RemoteException;
	void markAsContaminated(String label) throws RemoteException;
}
