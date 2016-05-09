package model;

public class Receipt {
	
	private String client;
	private Package porkPackage;
	
	public Receipt(String client, Package porkPackage) {
		this.client = client;
		this.porkPackage = porkPackage;
	}
	
	public String getClient() {
		return client;
	}
	
	public Package getPorkPackage() {
		return porkPackage;
	}
}
