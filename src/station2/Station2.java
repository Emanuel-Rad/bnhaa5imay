package station2;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import model.Package;
import model.Part;

public class Station2 implements Station2Interface {
	private static final int PORT = 9080;

	Package ph1, ph2, pp1, pp2;
	
	public static void main(String[] args) throws Exception {
		Station2 server = new Station2();
		server.init();
		Station2Interface stub = (Station2Interface) UnicastRemoteObject.exportObject(server, PORT);
		LocateRegistry.createRegistry(1099);
		LocateRegistry.getRegistry(1099).rebind("Station2", stub);
		server.init();
	}
	private void init() {
		ph1 = new Package(1000);
		ph2 = new Package(1001);
		pp1 = new Package(1002);
		pp2 = new Package(1003);
		Part part1 = new Part("P1234L1", 100);//
		Part part2 = new Part("P1234L2", 101);//
		Part part3 = new Part("P1234L3", 102); //
		Part part4 = new Part("P1234L4", 103); //
		Part part5 = new Part("P9874L1", 104); //
		Part part6 = new Part("P9874L2", 104); //
		Part part7 = new Part("P9874L3", 104); //
		Part part8 = new Part("P9874L4", 104); //
		Part part9 = new Part("P1234B1", 105); //
		Part part10 = new Part("P1234B2", 106);//
		Part part11 = new Part("P9874B1", 107); //
		Part part12 = new Part("P9874B2", 108); //
		
		ph1.addPart(part9);
		ph1.addPart(part5);
		ph1.addPart(part6);
		ph2.addPart(part11);
		ph2.addPart(part1);
		ph2.addPart(part2);
		pp1.addPart(part10);
		pp1.addPart(part12);
		pp2.addPart(part3);
		pp2.addPart(part4);
		pp2.addPart(part7);
		pp2.addPart(part8);
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
