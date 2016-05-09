package model;

public class Part {
	
	public static final String LEG = "leg";
	public static final String HALFBODY = "halfbody";
	
	private String type;
	private int weight;
	private String label;
	private boolean isContaminated;
	private String porkReference;
	
	public Part(String porkReference, String type, int weight, String label, boolean isContaminated) {
		this.porkReference = porkReference;
		this.type = type;
		this.weight = weight;
		this.label = label;
		this.isContaminated = isContaminated;
	}

	public boolean isContaminated() {
		return isContaminated;
	}

	public void setContaminated(boolean isContaminated) {
		this.isContaminated = isContaminated;
	}
	
	public String getPorkReference() {
		return porkReference;
	}

	public String getType() {
		return type;
	}

	public int getWeight() {
		return weight;
	}

	public String getLabel() {
		return label;
	}
}
