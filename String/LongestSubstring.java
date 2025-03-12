package String;

import java.util.HashMap;

public class LongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int maxlength=0;
        int currLength=0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                currLength=1;
            }else{
                map.put(s.charAt(i), i);
                currLength++;
                maxlength=Math.max(maxlength, currLength);
            }
        }
        return maxlength;
    }
    public static void main(String[] args) {
        String s="bbbbbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
