class Solution {
    public int maximumDifference(int[] nums) {
        int max_diff = -1;
        int n = nums.length;
        if(n==1) return max_diff;
        int min_ele = nums[0];
        for(int i = 1; i<n;i++){
            if(min_ele!=nums[i]){
                 max_diff = Math.max(max_diff,nums[i] - min_ele);
                min_ele = Math.min(min_ele,nums[i]);
            }
       
        }
        return max_diff;
    }
}