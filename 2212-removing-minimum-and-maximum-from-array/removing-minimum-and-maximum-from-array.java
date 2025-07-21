class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if (n == 1) return 1;

        // Find min and max with their indices
        int minVal = Integer.MAX_VALUE, maxVal = Integer.MIN_VALUE;
        int minIndex = -1, maxIndex = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] < minVal) {
                minVal = nums[i];
                minIndex = i;
            }
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                maxIndex = i;
            }
        }

        // Case 1: remove both from front
        int del_front = Math.max(minIndex, maxIndex) + 1;

        // Case 2: remove both from end
        int del_end = n - Math.min(minIndex, maxIndex);

        // Case 3: remove one from front, one from end
        int del_fe = Math.min(
            (minIndex + 1) + (n - maxIndex),
            (maxIndex + 1) + (n - minIndex)
        );

        return Math.min(del_front, Math.min(del_end, del_fe));
    }
}
