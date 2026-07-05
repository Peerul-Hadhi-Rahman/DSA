class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        k=k%n;
        int d=n-k;
      
        reverse(0, d-1, nums);
        reverse(d, n-1, nums);
        reverse(0, n-1, nums);
    }

    private void reverse(int left, int right, int[] arr) {
        while(left<right) {
        int temp=arr[left];
        arr[left]=arr[right];
        arr[right]=temp;
        left++;
        right--;
        }
    }
}
