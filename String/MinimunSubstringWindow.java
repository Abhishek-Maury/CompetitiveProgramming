package String;

import java.util.HashMap;
// https://leetcode.com/problems/minimum-window-substring/description/
//Leetcode Hard ( Amazon Google MakeMyTrip Streamoid Technologies Microsoft Media.net Atlassian Flipkart)

public class MinimunSubstringWindow {
    public static String minWindow(String s,String t){
          if (t==null || s==null ||t.length()>s.length()) {
            return "";
        }
        HashMap<Character,Integer> map = new HashMap<>();
        for ( char c :t.toCharArray() ) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        int left=0,right=0;
        int minLength=Integer.MAX_VALUE;
        int count =map.size();
        int start=0;

        while (right<s.length()) {
            if (map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), map.get(s.charAt(right))-1);
                if (map.get(s.charAt(right))==0) {
                    count--;
                }
            }
            right++;

            while (count==0) {
                if (right-left<minLength) {
                    minLength=right-left;
                    start=left;
                }

                if (map.containsKey(s.charAt(left))) {
                    map.put(s.charAt(left), map.get(s.charAt(left))+1);
                    if (map.get(s.charAt(left))>0) {
                        count++;
                    }
                }
                left++;
            }
        }
        return minLength==Integer.MAX_VALUE ?"":s.substring(start, start+minLength);


    }
    public static void main(String[] args) {
        String s="aa";
        String p="aa";
        System.out.println(minWindow(s, p));
    }
}
