package com.franka.objectmaster;

public class Samurai extends Human {
	
	
	public Samurai() {
		this.setHealth(200);
		samuraiAlive++;
	}
	
	public void setAlive(boolean alive) {
		if(!alive)
			samuraiAlive--;
		super.setAlive(alive);
	}
	
	public void deathBlow(Human target) {
		target.setHealth(0);
		this.setHealth(this.getHealth()/2);
	}
	
	public void meditate() {
		this.setHealth((int)(this.getHealth()*1.5));
	}
	
	public int howMany() {
		return samuraiAlive;
	}
}
