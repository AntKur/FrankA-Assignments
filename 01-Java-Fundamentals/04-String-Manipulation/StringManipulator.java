public class StringManipulator{
    
    public String trimAndConcat(String s1, String s2){
        s1 = s1.trim();
        s2 = s2.trim();
        return s1.concat(s2);
    }

    public Integer getIndexOrNull(String s1, char chr){
        int i = s1.indexOf(chr);
        if(i == -1)
            return null;
        else
            return i;    
    }

    public Integer getIndexOrNull(String s1, String s2){
        int i = s1.indexOf(s2);
        if(i == -1)
            return null;
        else
            return i; 
    }

    public String concatSubstring(String s1, int a, int b, String s2){
        s1 = s1.substring(a,b);
        return s1.concat(s2);
    }
}