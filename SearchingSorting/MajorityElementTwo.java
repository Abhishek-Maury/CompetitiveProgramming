package SearchingSorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElementTwo {
      public List<Integer> majorityElement(int[] arr) {
        ArrayList<Integer> al=new ArrayList<>();
         HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        for (Map.Entry<Integer,Integer> entry :map.entrySet()){
            int element = entry.getKey();
            int count = entry.getValue();
            if(count>n/3){
                al.add(element);
            }
        }
         return al;
    }
    public static void main(String[] args) {
        
    }
}
