package String;

import java.util.HashMap;
import java.util.Map;

public class TransformOneStringToAnother {

    public static int transformer(String A,String B){
        int n=A.length();
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(A.charAt(i))) {
                map.put(A.charAt(i), map.get(A.charAt(i))+1);
            }else{
                map.put(A.charAt(i), +1);
            }
        }

        for (int i = 0; i < n; i++) {
            if (map.containsKey(B.charAt(i))) {
                map.put(B.charAt(i), map.get(B.charAt(i))-1);
            }
        }

        for (Map.Entry<Character,Integer> entry: map.entrySet()) {
            if (entry.getValue()!=0) {
                return -1;
            }
        }

        int i=n-1,j=n-1;
        int res=0;
        while (i>=0&&j>=0) {
            while (i>=0 && A.charAt(i)!=B.charAt(j)) {
                res++;
                i--;
            }
            i--;
            j--;
        }
        return res;

    }
    public static void main(String[] args) {
        String a = "EACBD";
        String b = "EABCD";
        System.out.println(transformer(a, b));
    }
    
}
