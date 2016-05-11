package station2;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import model.Package;
import model.Part;
import model.Pork;

public class Station2 implements Station2Interface {
	private static final int PORT = 9080;
	
	public static void main(String[] args) throws Exception {
		Station2 server = new Station2();
		Station2Interface stub = (Station2Interface) UnicastRemoteObject.exportObject(server, PORT);
		LocateRegistry.createRegistry(1099);
		LocateRegistry.getRegistry(1099).rebind("Station2", stub);
	}
	
	@Override
	public void receivePigs(ArrayList<Pork> porks) throws RemoteException {
		System.out.println("in station 2");
		
	}

	@Override
	public ArrayList<Package> getMixPackages(String shop, int n) throws RemoteException {
		ArrayList<Package> ret = new ArrayList<>();
		ret.add(ph1);
		if (n == 2)
			ret.add(ph2);
		return ret;
	}

	@Override
	public ArrayList<Package> getPartPackages(String shop, char type, int n) throws RemoteException {
		ArrayList<Package> ret = new ArrayList<>();
		ret.add(pp1);
		if (n == 2)
			ret.add(pp2);
		return ret;
	}

	@Override
	public void markAsContaminated(String label) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
}
