class Solution {
    public int countPartitions(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        pre[0] = nums[0];
        int[] post = new int[n];
        post[n-1] = nums[n-1];
        for(int i = 1; i<n;i++){
            pre[i] = pre[i-1] + nums[i];
        }
        for(int i = n-2; i>=0;i--){
            post[i] = post[i+1] + nums[i];
        }
      
        int count = 0;
        for( int i = 0; i<n-1;i++){
            if((pre[i] - post[i+1]) % 2 == 0 ){
            
               count +=1;
            } 
        }
        return count;
    }
}