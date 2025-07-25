class Solution {
    public int maxSum(int[] nums) {
        int maxs = Integer.MIN_VALUE;
        int maxsum = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0 ; i<nums.length;i++){
            if(nums[i] > 0){
                if(!set.contains(nums[i])){
                    set.add(nums[i]);
                    maxsum +=nums[i];
                }
            } 
            maxs = Math.max(maxs,nums[i]);
           
        }
        if(maxs < 0) return maxs;
        return maxsum;
    }
}