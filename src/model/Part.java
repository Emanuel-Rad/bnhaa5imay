package model;

import java.io.Serializable;

public class Part implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public static final String LEG = "leg";
	public static final String HALFBODY = "halfbody";
	
	private String label;	
	private String type;
	private int weight;
	private boolean isContaminated;
	
	public Part(String label, String type, int weight, boolean isContaminated) {
		this.label = label;
		this.type = type;
		this.weight = weight;
		this.isContaminated = isContaminated;
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
	
	public String getType() {
		return type;
	}

	public int getWeight() {
		return weight;
	}
}
