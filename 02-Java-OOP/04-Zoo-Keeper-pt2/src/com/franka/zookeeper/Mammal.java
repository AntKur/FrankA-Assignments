package com.franka.zookeeper;

public class Mammal{
    private int energyLevel;

    public Mammal(){
        energyLevel = 100;
    }

    public int displayEnergy(){
        System.out.println("Current energy level: " +energyLevel);
        return energyLevel;
    }

    public void setEnergyLevel(int i){
        energyLevel = i;
    }
}