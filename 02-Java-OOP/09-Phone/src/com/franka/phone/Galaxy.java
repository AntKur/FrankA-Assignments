package com.franka.phone;

public class Galaxy extends Phone implements Ringable {
	public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
		super(versionNumber, batteryPercentage, carrier, ringTone);
	}
	
	public String ring() {
		String s = "Galaxy " +this.getVersionNumber() + " says " +this.getRingTone();
		return s;
	}
	
	public String unlock() {
		return "Unlocking via Ultrasonic Fingerprint Scanner";
	}
	
	public void displayInfo() {
		System.out.println("Galaxy " +this.getVersionNumber() +" from " +this.getCarrier());
	}
}

