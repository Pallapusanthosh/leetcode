class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1); // default all to -1

        if (k == 0) return nums;
        int windowSize = 2 * k + 1;
        if (windowSize > n) return ans;

        long sum = 0;
        // initial window sum [0..2k]
        for (int i = 0; i < windowSize; i++) {
            sum += nums[i];
        }
        ans[k] = (int)(sum / windowSize);

        // slide the window
        for (int i = windowSize; i < n; i++) {
            sum += nums[i];
            sum -= nums[i - windowSize];
            ans[i - k] = (int)(sum / windowSize);
        }

        return ans;
    }
}
