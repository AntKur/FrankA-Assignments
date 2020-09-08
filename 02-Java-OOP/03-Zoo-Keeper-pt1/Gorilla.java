public class Gorilla extends Mammal{

    public void throwSomething(){
        setEnergyLevel(displayEnergy()-5);
        System.out.println("Gorilla threw something!");
    }

    public void eatBananas(){
        setEnergyLevel(displayEnergy()+10);
        System.out.println("Gorilla ate bananas and is content.");
    }

    public void climb(){
        setEnergyLevel(displayEnergy()-10);
        System.out.println("Gorilla has climbed a tree.");
    }
}