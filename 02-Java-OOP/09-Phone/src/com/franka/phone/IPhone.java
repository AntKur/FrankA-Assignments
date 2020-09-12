package com.franka.phone;

public class IPhone extends Phone implements Ringable {
	public IPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
		super(versionNumber, batteryPercentage, carrier, ringTone);
	}
	
	public String ring() {
		String s = "IPhone " +this.getVersionNumber() + " says " +this.getRingTone();
		return s;
	}
	
	public String unlock() {
		return "Unlocking via FaceID";
	}
	
	public void displayInfo() {
		System.out.println("iPhone " +this.getVersionNumber() +" from " +this.getCarrier());
	}
}
