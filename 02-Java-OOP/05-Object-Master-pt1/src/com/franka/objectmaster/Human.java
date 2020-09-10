package com.franka.objectmaster;

public class Human {
	private int strength, stealth, intelligence, health;
	
	public Human() {
		strength = 3;
		stealth = 3;
		intelligence = 3;
		health = 100;
	}
	
	public int getStrength() {
		return this.strength;
	}
	
	public int getStealth() {
		return this.stealth;
	}
	
	public int getIntelligence() {
		return this.intelligence;
	}
	
	public int getHealth() {
		return  this.health;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	public void attack(Human enemy) {
		enemy.setHealth(enemy.getHealth()-this.strength);
	}
	
}
