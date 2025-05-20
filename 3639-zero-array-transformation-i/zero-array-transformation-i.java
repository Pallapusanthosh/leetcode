class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];

        // Step 1: Build the difference array from queries
        for (int[] q : queries) {
            int l = q[0], r = q[1];
            diff[l] += 1;
            if (r + 1 < n) diff[r + 1] -= 1;
        }

        // Step 2: Apply the difference array to get frequency at each index
        int[] count = new int[n];
        count[0] = diff[0];
        for (int i = 1; i < n; i++) {
            count[i] = count[i - 1] + diff[i];
        }

        // Step 3: Check if every index has enough decrements
        for (int i = 0; i < n; i++) {
            if (count[i] < nums[i]) return false;
        }

        return true;
    }
}
