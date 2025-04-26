class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long count = 0;
        int left = 0;
        int lastMinK = -1;  // Last position where minK was found
        int lastMaxK = -1;  // Last position where maxK was found
        int lastInvalid = -1;  // Last position where an invalid element was found

        for (int right = 0; right < nums.length; right++) {
            // If the current element is out of bounds, reset the window
            if (nums[right] < minK || nums[right] > maxK) {
                lastInvalid = right;
            }
            // If the current element is minK, update lastMinK
            if (nums[right] == minK) {
                lastMinK = right;
            }
            // If the current element is maxK, update lastMaxK
            if (nums[right] == maxK) {
                lastMaxK = right;
            }

            // If both minK and maxK are within the window, count the valid subarrays
            if (lastMinK != -1 && lastMaxK != -1) {
                // The number of subarrays ending at `right` is determined by the left pointer
                count += Math.max(0, Math.min(lastMinK, lastMaxK) - lastInvalid);
            }
        }

        return count;
    }
}
