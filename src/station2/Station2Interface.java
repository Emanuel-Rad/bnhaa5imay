package station2;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import model.Package;

public interface Station2Interface extends Remote {
	ArrayList<Package> getHalfPackages(int n) throws RemoteException;
	ArrayList<Package> getMixPackages(String type, int n) throws RemoteException;
}
