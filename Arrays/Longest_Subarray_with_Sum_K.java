import java.util.*;
public class Main {
    public static void main(String[] args) {
      int[] nums={1,2,1,1,1,3,2};
      int k=3, n=nums.length;
      
      int l=0;
      int sum=0, maxLen=0;
      
      for(int r=0;r<n;r++) {
        sum+=nums[r];
        
        while(sum>k) {
          sum-=nums[l];
          l++;
        }
        if(sum==k) maxLen=Math.max(maxLen, r-l+1);
      }
      System.out.print(maxLen);
  }
}
