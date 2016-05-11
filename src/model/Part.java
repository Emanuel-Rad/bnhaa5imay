package model;

import java.io.Serializable;

public class Part implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public static final String MIX = "MIX";
	public static final String LEG = "LEG";
	public static final String HALFBODY = "HALFBODY";
	
	private String label;
	private int weight;
	private boolean isContaminated;
	
	public Part(String label, int weight) {
		this.label = label;
		this.weight = weight;
		this.isContaminated = false;
	}

	public boolean isContaminated() {
		return isContaminated;
	}

	public void setContaminated(boolean isContaminated) {
		this.isContaminated = isContaminated;
	}


	public String getLabel() {
		return label;
	}

	public int getWeight() {
		return weight;
	}
}
