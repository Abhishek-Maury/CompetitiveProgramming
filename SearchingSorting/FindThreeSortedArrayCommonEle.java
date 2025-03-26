package SearchingSorting;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

// https://www.geeksforgeeks.org/find-common-elements-three-sorted-arrays/
public class FindThreeSortedArrayCommonEle {
    
public static ArrayList<Integer> commonElements( ArrayList<Integer> arr1, ArrayList<Integer> arr2, ArrayList<Integer> arr3  ){

    TreeMap<Integer,Integer> map = new TreeMap<>();

    for (Integer ele : arr1) {
        map.put(ele, 1);
    }

    for (Integer ele2 : arr2) {
        if (map.containsKey(ele2) && map.get(ele2)==1) {
            map.put(ele2, 2);
        }
    }

    for (Integer ele : arr3) {
        if (map.containsKey(ele) && map.get(ele)==2) {
            map.put(ele, 3);
        }
    }
    
    ArrayList<Integer> commonElements=new ArrayList<>();
    for (int ele : map.keySet()) {
        if (map.get(ele)==3) {
            commonElements.add(ele);
        }
    }
    return commonElements;
}
    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>(List.of(1,5,10,20,30));
        ArrayList<Integer> arr2 = new ArrayList<>(List.of(5,13,15,20));
        ArrayList<Integer> arr3 = new ArrayList<>(List.of(5,20));
        ArrayList<Integer> common = commonElements(arr1, arr2, arr3);
        if (common.size()==0) {
            System.out.println(-1);
        }
        for (int i = 0; i < common.size(); i++) {
            System.out.print(common.get(i)+" ");
        }
    }
}
