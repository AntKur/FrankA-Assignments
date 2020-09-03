public class StringManipulatorTest{
    public static void main(String[] args){
        StringManipulator mani = new StringManipulator();
        String str = mani.trimAndConcat("  Hello  ","   World   ");
        System.out.println(str);

        char letter = 'o';
        Integer a = mani.getIndexOrNull("Coding", letter);
        Integer b = mani.getIndexOrNull("Hello World", letter);
        Integer c = mani.getIndexOrNull("Hi", letter);
        System.out.println(a); // 1
        System.out.println(b); // 4
        System.out.println(c); // null

        String word = "Hello";
        String subString = "llo";
        String notSubString = "world";
        Integer d = mani.getIndexOrNull(word, subString);
        Integer e = mani.getIndexOrNull(word, notSubString);
        System.out.println(d); // 2
        System.out.println(e); // null

        String word2 = mani.concatSubstring("Hello",1,2,"world");
        System.out.println(word2);

    }
}