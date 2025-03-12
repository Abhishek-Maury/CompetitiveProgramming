package String;

// https://leetcode.com/problems/longest-repeating-character-replacement/description/
import java.util.HashMap;

public class LongestRepeating {
    public static int characterReplacement(String s, int k) {
        HashMap<Character,Integer> map=new HashMap<>();
        int res=0,i=0,maxFreq=0;
        for (int j = 0; j < s.length(); j++) {
            char c=s.charAt(j);
            map.put(c, map.getOrDefault(c, 0)+1);
            maxFreq=Math.max(maxFreq, map.get(c));
            while ((j-i+1)-maxFreq>k) {
                char left =s.charAt(i);
                map.put(left, map.get(left)-1);
                i++;
            }
            res=Math.max(res, j-i+1);
        }
        return res;
    }
    public static void main(String[] args) {
        String s="aababba";
        System.out.println(characterReplacement(s, 1));
    }
}
