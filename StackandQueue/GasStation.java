package StackandQueue;

public class GasStation {

    public static int circularTour(int[] gas,int[] cost){
        int totalgas=0,totalcost=0;
        for (int i : gas) {
            totalgas+=i;
        }
        for (int ele : cost) {
            totalcost+=ele;
        }

        if (totalgas<totalcost) {
            return -1;
        }

        // and now we know that a unique start is valid
        int start=0,currGas=0;
        for (int i = 0; i < gas.length; i++) {
            currGas+=(gas[i]-cost[i]);
            if (currGas<0) {
                start=i+1;
                currGas=0;
            }
        }
        return start;
    }

    //little bit optimized
     public static int circularTour2(int[] gas,int[] cost){
        int totalgas=0,totalcost=0;

        if (totalgas<totalcost) {
            return -1;
        }

        int start=0,currGas=0;
        for (int i = 0; i < gas.length; i++) {
            totalgas+=gas[i];
            totalcost+=cost[i];
            currGas+=(gas[i]-cost[i]);
            if (currGas<0) {
                start=i+1;
                currGas=0;
            }
        }
        return totalgas < totalcost ?-1 :start;
    }
    public static void main(String[] args) {
        int[] gas={1,2,4,5,9};
        int[] cost={3,4,1,10,1};
        System.out.println(circularTour2(gas, cost));
    }
}
