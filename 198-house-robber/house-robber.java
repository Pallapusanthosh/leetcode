class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1); 
        dp[0] = nums[0];
        int pick = -1;
        for(int i =1; i<n;i++){
            pick = nums[i] + 0;
            if(i >1)  pick = nums[i]+dp[i-2];
            
            int notpick = dp[i-1];
            dp[i] = Math.max(pick , notpick);
        }
        return dp[n-1];
    }

    // public int robb(int i, int[] nums, int[] dp) {
    //     if (i < 0) return 0;
    //     if (i == 0) return nums[0];
    //     if (dp[i] != -1) return dp[i];

    //     int pick = nums[i] + robb(i - 2, nums, dp);
    //     int notpick = robb(i - 1, nums, dp);
    //     return dp[i] = Math.max(pick, notpick);
    // }
}
