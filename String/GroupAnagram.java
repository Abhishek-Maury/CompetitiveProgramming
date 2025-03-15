package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// https://leetcode.com/problems/group-anagrams/description/

public class GroupAnagram {
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length==0||strs==null) {
            return new ArrayList<>();
        }
        HashMap<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            String freqString = getFrequencyString(str);

            if (map.containsKey(freqString)) {
                map.get(freqString).add(str);
            }else{
                List<String> stlist = new ArrayList<>();
                stlist.add(str);
                map.put(freqString, stlist);
            }
        }
        return new ArrayList<>(map.values());
    }
    private static String getFrequencyString(String str){
         int[] freq=new int[26];
         for (char c :str.toCharArray()) {
            freq[c-'a']++;
         }

         StringBuilder freqString = new StringBuilder();
         char c='a';
         for (int i : freq) {
            freqString.append(c);
            freqString.append(i);
            c++;
         }
         return freqString.toString();
    }
    public static void main(String[] args) {
        
String[]strs = {"eat","tea","tan","ate","nat","bat"};
System.out.println(groupAnagrams(strs));
    }
}
