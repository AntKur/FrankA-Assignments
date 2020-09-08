package com.franka.zookeeper;

public class Bat extends Mammal {
	public Bat() {
		setEnergyLevel(300);
	}
	
	public void fly() {
		setEnergyLevel(displayEnergy()-50);
		System.out.println("Wooosh!");
	}
	
	public void eatHumans() {
		setEnergyLevel(displayEnergy()+25);
		System.out.println("Chomp!");
	}
	
	public void attackTown() {
		setEnergyLevel(displayEnergy()-100);
		System.out.println("Aaahhhhh!!!");
	}
}
