import java.util.ArrayList;

public class Except{
    public static void main(String[] args){
        ArrayList<Object> list = new ArrayList<Object>();
        list.add(12);
        list.add("ewoijsfm");
        list.add("wegrb");
        list.add(2);
        for(int i = 0; i<list.size(); i++){
            try{
                Integer val = (Integer)list.get(i);
            } catch (Exception e){
                System.out.println(e);
                System.out.println("Index: " +i);
                System.out.println(list.get(i));
            }
        }
    }
}