package SearchingSorting;

import java.util.*;
// https://www.geeksforgeeks.org/find-duplicates-in-on-time-and-constant-extra-space/

public class FindDuplicates {
    public static List<Integer> search(int[] arr){
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> res=new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
       for( Map.Entry<Integer,Integer> entry:map.entrySet()){
           if (entry.getValue()>1) {
            res.add(entry.getKey());
           }
        }
        if (res.isEmpty()) {
            res.add(-1);
        }
        return res;
  
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,6,3,6,1};
        List<Integer> ans= search(arr);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i)+" ");
        }

    }
}
