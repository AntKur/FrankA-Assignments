import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class PuzzleJava{

    public ArrayList<Integer> sumAndGreater(int[] arr){
        int sum = 0;
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for(int i : arr){
            sum += i;
            if(i>10)
                nums.add(i);
        }
        System.out.println("Sum: " +sum);
        return nums;
    }

    public ArrayList<String> shuffleAndPrint(ArrayList<String> arr){
        Collections.shuffle(arr);
        System.out.println(arr);
        for(int i = arr.size()-1; i>=0;i--){
            if(arr.get(i).length()<6)
                arr.remove(i);
        }

        return arr;
    }

    public int[] randomInts(){
        Random ran = new Random();
        int[] nums = new int[10];
        for(int i = 0; i<nums.length; i++){
            nums[i] = ran.nextInt(45)+55;
        }

        return nums;
    }

    public String randomFive(){
        Random ran = new Random();
        String str = "";
        for(int i = 0 ;i<5;++i){
            char ch = (char)(ran.nextInt(25) + 97);
            str += ch;
        }

        return str;
    }

    public String[] randomStrings(){
        String[] randos = new String[10];
        for(int i = 0; i<10;++i){
            randos[i] = randomFive();
        }

        return randos;
    }
}