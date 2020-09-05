import java.util.HashMap;

public class Map{
    public static void main(String[] args){
        HashMap<String, String> trackList = new HashMap<String, String>();
        trackList.put("Intro: Wow", "This is an intro song wow!");
        trackList.put("Title Song", "This is the title song");
        trackList.put("Single", "This is a single");
        trackList.put("Outro: Bye", "This is the outro track");
        System.out.println(trackList.get("Title Song"));

        for(HashMap.Entry<String, String> track : trackList.entrySet()){
            System.out.println(track.getKey() + " : " + track.getValue());
        }
    }
}