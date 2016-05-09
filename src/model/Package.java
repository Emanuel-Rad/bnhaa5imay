package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Package implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private int weight;
	private ArrayList<Part> parts;
	
	public Package(int id) {
		parts = new ArrayList<>();
		this.id = id;
	}
	
	public void addPart(Part part) {
		weight += part.getWeight();
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
