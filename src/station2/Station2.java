package station2;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import model.Package;

public class Station2 implements Station2Interface {
	private static final int PORT = 9080;

	public static void main(String[] args) throws Exception {
		Station2 server = new Station2();
		Station2Interface stub = (Station2Interface) UnicastRemoteObject.exportObject(server, PORT);
		LocateRegistry.createRegistry(1099);
		LocateRegistry.getRegistry(1099).rebind("Station2", stub);
		System.out.println("Server started");
	}

	@Override
	public ArrayList<Package> getHalfPackages(int n) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Package> getMixPackages(String type, int n) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
}
