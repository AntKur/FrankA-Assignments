import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class PuzzleJavaTest {
    public static void main(String[] args) {
        PuzzleJava puzzle = new PuzzleJava();
        int[] arr = {3,5,1,2,7,9,8,13,25,32};
        System.out.println(puzzle.sumAndGreater(arr));
        
        ArrayList<String> names = new ArrayList<>(Arrays.asList("Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa"));
        System.out.println(puzzle.shuffleAndPrint(names));

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for(char ch = 'a'; ch <= 'z'; ++ch){
            alphabet.add(ch);
        }
        Collections.shuffle(alphabet);
        System.out.println(alphabet.get(25));
        System.out.println(alphabet.get(0));
        switch (alphabet.get(0)) {
            case 'a':
                System.out.println("First letter is a vowel");
                break;
            case 'e':
                System.out.println("First letter is a vowel");
                break;
            case 'i':
                System.out.println("First letter is a vowel");
                break;
            case 'o':
                System.out.println("First letter is a vowel");
                break;
            case 'u':
                System.out.println("First letter is a vowel");
                break;    
        }

        System.out.println(Arrays.toString(puzzle.randomInts()));

        int[] randomNums = puzzle.randomInts();
        Arrays.sort(randomNums);
        System.out.println(Arrays.toString(randomNums));
        System.out.println("Minimum value is " +randomNums[0] );
        System.out.println("Maximum value is " +randomNums[9] );
        
        System.out.println(puzzle.randomFive());

        System.out.println(Arrays.toString(puzzle.randomStrings()));
        /*Collections.shuffle(numbers);
        System.out.println(numbers); // [1, 5, 2, 4, 3]
        Collections.sort(numbers);
        System.out.println(numbers); // [1, 2, 3, 4, 5]
                
        Random r = new Random();
        System.out.println(r.nextInt()); // without bounds
        System.out.println(r.nextInt(5)); // with bounds 0 to 5
        */
    }
}