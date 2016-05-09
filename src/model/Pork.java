package model;

import java.io.Serializable;

public class Pork implements Serializable {

	private static final long serialVersionUID = 1L;
	private String label;
	private int weight;
	
	public Pork(String label, int wight) {
		this.label = label;
		this.weight = wight;
	}
	
	public static Part[] split(Pork pork) {
		throw new IllegalStateException();
	}

	public String getLabel() {
		return label;
	}

	public int getWeight() {
		return weight;
	}
}
