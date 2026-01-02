class Solution {
    
    void maxHeap(int[] arr, int n, int i) {
        
        int largest=i;
        int left=2*i+1;
        int right=2*i+2;
        
        if (left < n && arr[largest] < arr[left]) {
            largest=left;
        }
        if (right < n && arr[largest] < arr[right]) {
            largest=right;
        }
        if (largest!=i) {
            int temp=arr[i];
            arr[i]=arr[largest];
            arr[largest]=temp;
            maxHeap(arr, n, largest);
        }
    }
    public int[] mergeHeaps(int[] a, int[] b, int n, int m) {
        
        int[] ans=new int[n+m];
        int idx=0;
        for (int i:a) {
            ans[idx++]=i;
        }
         for (int i:b) {
            ans[idx++]=i;
        }
        for (int i=(n+m)/2-1;i>=0;i--) {
            maxHeap(ans, n+m, i);
        }
        return ans;
    }
}
