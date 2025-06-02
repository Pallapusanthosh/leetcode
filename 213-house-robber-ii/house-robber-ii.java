class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        // Rob from 0 to n-2
        int[] dp1 = new int[n - 1];
        dp1[0] = nums[0];
        for (int i = 1; i < n - 1; i++) {
            int pick = nums[i] + (i > 1 ? dp1[i - 2] : 0);
            int notpick = dp1[i - 1];
            dp1[i] = Math.max(pick, notpick);
        }

        // Rob from 1 to n-1
        int[] dp2 = new int[n - 1];
        dp2[0] = nums[1];
        for (int i = 1; i < n - 1; i++) {
            int pick = nums[i + 1] + (i > 1 ? dp2[i - 2] : 0);
            int notpick = dp2[i - 1];
            dp2[i] = Math.max(pick, notpick);
        }

        return Math.max(dp1[n - 2], dp2[n - 2]);
    }
}
