import java.util.Arrays;

public class BasicJavaTest{
    public static void main(String[] args){
        BasicJava basic = new BasicJava();

        basic.print1to255();

        basic.printOdd1to255();

        basic.printSum();

        int[] arr = {1,3,5,7,9,13};
        basic.printArray(arr);
        
        int[] arr2 = {-3,-5,-7};
        basic.findMax(arr2);

        double[] arr3 = {2,3,10};
        System.out.println(basic.getAverage(arr3));

        System.out.println(basic.arrayOdd());

        int[] arr4 = {1,3,5,7};
        int y = 3;
        basic.greaterThanY(arr4,y);

        int[] arr5 = {1,5,10,-2};
        System.out.println(Arrays.toString(basic.squareValues(arr5)));

        int[] arr6 = {1,5,10,-2};
        System.out.println(Arrays.toString(basic.noNegs(arr6)));

        double[] arr7 = {1,5,10,-2};
        System.out.println(Arrays.toString(basic.maxMinAvg(arr7)));

        int[] arr8 = {1,5,10,7,-2};
        System.out.println(Arrays.toString(basic.shiftArray(arr8)));
    }
}