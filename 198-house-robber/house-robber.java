class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1); // Use -1 to distinguish uncomputed states
        return robb(n - 1, nums, dp);
    }

    public int robb(int i, int[] nums, int[] dp) {
        if (i < 0) return 0;
        if (i == 0) return nums[0];
        if (dp[i] != -1) return dp[i];

        int pick = nums[i] + robb(i - 2, nums, dp);
        int notpick = robb(i - 1, nums, dp);
        return dp[i] = Math.max(pick, notpick);
    }
}
