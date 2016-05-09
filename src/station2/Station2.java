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
		System.out.println("Server started");
		server.init();
	}
	private void init() {
		ph1 = new Package(1000);
		ph2 = new Package(1001);
		pp1 = new Package(1002);
		pp2 = new Package(1003);
		Part part1 = new Part("P1234L1", Part.LEG, 100,  false);//
		Part part2 = new Part("P1234L2", Part.LEG, 101,  false);//
		Part part3 = new Part("P1234L3", Part.LEG, 102,  false); //
		Part part4 = new Part("P1234L4", Part.LEG, 103,  false); //
		Part part5 = new Part("P9874L1", Part.LEG, 104,  true); //
		Part part6 = new Part("P9874L2", Part.LEG, 104,  true); //
		Part part7 = new Part("P9874L3", Part.LEG, 104,  true); //
		Part part8 = new Part("P9874L4", Part.LEG, 104,  true); //
		Part part9 = new Part("P1234B1", Part.HALFBODY, 105, false); //
		Part part10 = new Part("P1234B2", Part.HALFBODY, 106, false);//
		Part part11 = new Part("P9874B1", Part.HALFBODY, 107, true); //
		Part part12 = new Part("P9874B2", Part.HALFBODY, 108, true); //
		
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
	public ArrayList<Package> getHalfPackages(int n) throws RemoteException {
		ArrayList<Package> ret = new ArrayList<>();
		ret.add(ph1);
		if (n == 2)
			ret.add(ph2);
		return ret;
	}

	@Override
	public ArrayList<Package> getPartPackages(String type, int n) throws RemoteException {
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
