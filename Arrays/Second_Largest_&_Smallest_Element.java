public class Solution {
    public static int[] getSecondOrderElements(int n, int []a) {
        int largest=a[0], smallest=a[0], 
        sLargest=Integer.MIN_VALUE, 
        sSmallest=Integer.MAX_VALUE;

        for(int i=1;i<n;i++) {
            if(a[i]>largest) {
                sLargest=largest;
                largest=a[i];
            }
            else if(a[i]<largest && a[i]>sLargest) {
                sLargest=a[i];
            }
            if(a[i]<smallest) {
                sSmallest=smallest;
                smallest=a[i];
            }

            else if(a[i]>smallest && a[i]<sSmallest) {
                sSmallest=a[i];
            }
        }
        return new int[]{sLargest, sSmallest};
    }
}
