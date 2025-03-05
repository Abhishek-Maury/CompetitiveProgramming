package array;

// https://leetcode.com/problems/container-with-most-water/
public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int n = height.length - 1;
        int lp = 0;
        int rp = n;
        int maxWater = 0;
        while (lp < rp) {
            int width = rp - lp;
            int ht = Math.min(height[lp], height[rp]);
            int currWt = width * ht;
            maxWater = Math.max(maxWater, currWt);

            if (height[lp] < height[rp]) {
                lp++;
            } else {
                rp--;
            }
        }
        return maxWater;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println(maxArea(arr));
    }
}
