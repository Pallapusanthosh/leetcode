class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int prev2 = 0;       // dp[i-2]
        int prev = nums[0];  // dp[i-1]

        for (int i = 1; i < n; i++) {
            int pick = nums[i] + (i > 1 ? prev2 : 0);
            int notpick = prev;
            int curr = Math.max(pick, notpick);

            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}
