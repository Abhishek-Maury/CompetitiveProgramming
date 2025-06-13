package Heaps;

import java.util.TreeMap;

public class HandOfStraights {
     public boolean isNStraightHand(int[] hand, int groupSize) {
        int length=hand.length;
        if(length%groupSize!=0){
            return false;
        }
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int card:hand){
            map.put(card,map.getOrDefault(card,0)+1);
        }
        while(!map.isEmpty()){
            int startCard=map.firstKey();
            for(int i=0;i<groupSize;i++){
                int currCard=startCard+i;
                if(!map.containsKey(currCard)){
                    return false;
                }
                int count=map.get(currCard);
                if(count==1){
                    map.remove(currCard);
                }else{
                    map.put(currCard,count-1);
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        
    }
}
