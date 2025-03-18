class Solution {
    public int longestNiceSubarray(int[] nums) {
        int max_length = 1;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int res = 0;
            for (int j = i; j < n; j++) {
                if ((res & nums[j]) == 0) {
                    res |= nums[j]; // Add nums[j] to the result set
                    max_length = Math.max(max_length, j - i + 1);
                } else {
                    break; // Break the loop if common bits are found
                }
            }
        }

        return max_length;
    }
}
