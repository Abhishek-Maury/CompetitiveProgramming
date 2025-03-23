package String;

import java.util.HashMap;

public class SmallestWindowContainingAllCharacterOfAnotherString {

    public static String smallestWindow(String s,String p){
        if (p=="") {
            return "-1";
        }
        if (p.length()>s.length()) {
            return "-1";
        }

        HashMap<Character,Integer> pat = new HashMap<>();
        HashMap<Character,Integer> map = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            pat.put(p.charAt(i), pat.getOrDefault(p.charAt(i), 0)+1);
        }

        int currLength=0;
        int totLength=p.length();

        String res = "-1";
        int resLen = Integer.MAX_VALUE;
        int l=0;
        int r=0;
        while (r<s.length()) {
            char c=s.charAt(r);
            map.put(c, map.getOrDefault(c, 0)+1);
            if (pat.containsKey(c)&&pat.get(c)==map.get(c)) {
                currLength++;
            }
            while (currLength==totLength) {
                if (r-l+1<resLen) {
                    res=s.substring(l, r+1);
                    resLen=r-l+1;
                }
                char t=s.charAt(l);
                map.put(t, map.get(t)-1);

                if (pat.containsKey(t)&&map.get(t)<pat.get(t)) {
                    currLength--;
                }
                l++;
            }
            r++;

        }
        return(resLen!=Integer.MAX_VALUE)?res:"-1";

    }

    public static void main(String[] args) {
        // String s="aa";
        // String p="aa";
        System.out.println(smallestWindow(s, p));
    }
}
