package model;

import java.util.ArrayList;

public class Package {
	
	private int id;
	private int weight;
	private ArrayList<Part> parts;
	
	public Package(int id, int weight) {
		this.id = id;
		this.weight = weight;
	}
	
	public void addPart(Part part) {
		parts.add(part);
	}
	
	public ArrayList<Part> getParts() {
		return parts;
	}

	public int getId() {
		return id;
	}

	public int getWeight() {
		return weight;
	}
}
