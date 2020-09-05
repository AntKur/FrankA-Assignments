import java.util.ArrayList;

public class BasicJava{

    public void print1to255(){
        for(int i = 1; i<=255; i++){
            System.out.println(i);
        }
    }

    public void printOdd1to255(){
        for(int i = 1; i<=255; i+=2){
            System.out.println(i);
        }
    }

    public void printSum(){
        int sum = 0;
        for(int i = 0; i<=255; i++){
            sum += i;
            System.out.printf("New number: %d Sum: %d\n",i,sum);
        }
    }

    public void printArray(int[] arr){
        for(int i : arr)
            System.out.println(i);
    }

    public void findMax(int[] arr){
        int max = arr[0];
        for(int i : arr)
            if(i > max)
                max = i;
        System.out.println(max);                
    }

    public double getAverage(double[] arr){
        double sum = 0;
        double avg;
        for(double i : arr)
            sum+=i;
        avg = sum / arr.length;
        return avg;
    }

    public ArrayList<Integer> arrayOdd(){
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i = 1; i<=255; i+=2){
            arr.add(i);
        }
        return arr;
    }

    public void greaterThanY(int[] arr, int y){
        int nums = 0;
        for(int i : arr)
            if(i>y)
                nums++;
        System.out.println(nums);        
    }

    public int[] squareValues(int[] arr){
        for(int i = 0; i < arr.length; i++){
            arr[i] = arr[i] * arr[i];
        }

        return arr;
    }

    public int[] noNegs(int[] arr){
        for(int i = 0; i < arr.length; i++){
            if(arr[i]<0)
                arr[i] = 0;
        }

        return arr;
    }

    public double[] maxMinAvg(double[] arr){
        double max = arr[0];
        double min = arr[0];
        double sumThenAvg = 0;
        for(double i : arr){
            if(i>max)
                max = i;
            if(i<min)
                min = i;
            sumThenAvg += i;    
        }
        sumThenAvg /= arr.length;
        double[] stuff = {max,min,sumThenAvg};
        return stuff;
    }

    public int[] shiftArray(int[] arr){
        for(int i = 0; i<arr.length-1; i++){
            arr[i] = arr[i+1];
        }
        
        arr[arr.length-1] = 0;

        return arr;
    }
}