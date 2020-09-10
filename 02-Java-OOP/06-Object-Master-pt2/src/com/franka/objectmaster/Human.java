package com.franka.objectmaster;

public class Human {
	private int strength, stealth, intelligence, health;
	protected static int samuraiAlive;
	private boolean alive;
	
	
	public Human() {
		strength = 3;
		stealth = 3;
		intelligence = 3;
		health = 100;
		alive = true;
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
	
	public boolean isAlive() {
		return this.alive;
	}
	
	public void setStrength(int strength) {
		this.strength = strength;
	}
	
	public void setStealth(int stealth) {
		this.stealth = stealth;
	}
	
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}
	
	public void setHealth(int health) {
		this.health = health;
		if(health <= 0)
			setAlive(false);
	}
	
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	public void attack(Human enemy) {
		enemy.setHealth(enemy.getHealth()-this.strength);
	}
	
}
