class Solution {
    public int maxSum(int[] nums) {
        int maxs = Integer.MIN_VALUE;
        int maxsum = 0;
        boolean[] f = new boolean[201];
        for(int i = 0 ; i<nums.length;i++){
            if(nums[i] > 0){
                if(!f[nums[i]]){
                    f[nums[i]] = true;
                    maxsum +=nums[i];
                }
            } 
            maxs = Math.max(maxs,nums[i]);
           
        }
        if(maxs < 0) return maxs;
        return maxsum;
    }
}