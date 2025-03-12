package String;
// https://www.geeksforgeeks.org/print-all-the-duplicates-in-the-input-string/

import java.util.*;

public class PrintDupliOcurren {
    public static void printOcc(String str){
        HashMap<Character,Integer> count = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (count.containsKey(str.charAt(i))) {
                count.put(str.charAt(i), count.get(str.charAt(i))+1);
            }else{
                count.put(str.charAt(i), 1);
            }
        }

        //print
        //for unordered iteration on map
        for (Map.Entry<Character,Integer> mapelemt: count.entrySet()) {
            if (mapelemt.getValue()>1) {
                System.out.println(mapelemt.getKey()+", count "+mapelemt.getValue());
            }
        }
    }
    public static void main(String[] args) {
        String s="geeksforgeeks";
        printOcc(s);

    }
}
