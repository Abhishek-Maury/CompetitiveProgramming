package Heaps;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskSheduler {
    public static int min(char[] tasks,int n){
        HashMap<Character,Integer> map=new HashMap<>();
        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0)+1);
        }
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(map.values());
        Queue<int[]> cooldown=new LinkedList<>();
        int time=0;
        while (!maxHeap.isEmpty()||!cooldown.isEmpty()) {
            time++;
            if (!cooldown.isEmpty()&&cooldown.peek()[0]==time) {
                maxHeap.add(cooldown.poll()[1]);
            }

            if (!maxHeap.isEmpty()) {
                int freq=maxHeap.poll();
                int remainingFreq=freq-1;
                if (remainingFreq>0) {
                    int nextAvailableTime=time+n+1;
                    cooldown.add(new int[]{nextAvailableTime,remainingFreq});
                }
            }
        }
        return time;
    }
    public static void main(String[] args) {
        
    }
}
