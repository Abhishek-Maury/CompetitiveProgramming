package SearchingSorting;

public class MergeTwoSortedArray {
    // Using insert of insertion sort 
    // https://www.geeksforgeeks.org/merge-two-sorted-arrays-o1-extra-space/
  
    public static void sort(int[] a,int[] b){
        for (int i = b.length-1; i >=0; i--) {
            if (a[a.length-1]>b[i]) {
                int last=a[a.length-1];
                int j=a.length-2;
                while (j>=0 && a[j]>b[i]) {
                    a[j+1]=a[j];
                    j--;
                }
                a[j+1]=b[i];
                b[i]=last;
            }
        }
        }
    
    public static void main(String[] args) {
        int[] a={2,4,7,10};
        int[] b={2,3};
        sort(a, b);
        for (int ele : a) {
            System.out.print(ele+" ");
        }
        System.out.println();
        for (int ele : b) {
            System.out.print(ele+" ");
        }
    }
}
