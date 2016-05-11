package station1;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Random;

import model.Pork;
import station2.Station2Interface;

//rmi client to main server
public class Station1Controller {

	private static Station2Interface server;
	private Random rn = new Random();
	private ArrayList<Pork> porks;
	int pork_id;

	public Station1Controller() throws RemoteException, NotBoundException {
		Registry registry;
		registry = LocateRegistry.getRegistry();
		server = (Station2Interface) registry.lookup("Station2");
		pork_id = 0;
	}

	public void recievePigs(int number) throws RemoteException {
		porks = new ArrayList<Pork>();
		for (int i = 0; i < number; i++)
			porks.add(new Pork("P" + pork_id++, rn.nextInt(80) + 100));
		server.receivePigs(porks);
	}
}
