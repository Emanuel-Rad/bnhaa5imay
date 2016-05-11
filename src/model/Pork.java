package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Pork implements Serializable {

	private static final long serialVersionUID = 1L;
	private String label;
	private int weight;
	
	public Pork(String label, int wight) {
		this.label = label;
		this.weight = wight;
	}
	
	public static ArrayList<Part> split(Pork pork) {
		Random r = new Random();
		ArrayList<Part> parts = new ArrayList<>();
		parts.add(new Part(pork.getLabel() + "L1", r.nextInt(100) + 100));
		parts.add(new Part(pork.getLabel() + "L2", r.nextInt(100) + 100));
		parts.add(new Part(pork.getLabel() + "L3", r.nextInt(100) + 100));
		parts.add(new Part(pork.getLabel() + "L4", r.nextInt(100) + 100));
		parts.add(new Part(pork.getLabel() + "B1", r.nextInt(100) + 300));
		parts.add(new Part(pork.getLabel() + "B2", r.nextInt(100) + 300));
		return parts;
	}

	public String getLabel() {
		return label;
	}

	public int getWeight() {
		return weight;
	}
}
