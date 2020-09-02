import java.lang.Math;

public class Pythagorean {
    public double calculateHypotenuse(double legA, double legB){
        double hyp = Math.sqrt(Math.pow(legA,2) + Math.pow(legB,2));
        return hyp;
    }
}