class Solution {
    public int maximumCandies(int[] candies, long k) {
        int left = 1, right = getMax(candies);
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canDistribute(candies, k, mid)) {
                left = mid + 1; // Try for a larger value
            } else {
                right = mid - 1; // Reduce the number of candies
            }
        }
        return right;
    }

    // Helper method to find the maximum element in the array
    private int getMax(int[] candies) {
        int max = 0;
        for (int c : candies) {
            max = Math.max(max, c);
        }
        return max;
    }

    // Helper method to check if we can distribute 'mid' candies to at least 'k' children
    private boolean canDistribute(int[] candies, long k, int mid) {
        long count = 0;
        for (int c : candies) {
            count += c / mid; // Number of children satisfied from this pile
        }
        return count >= k; // Check if we can satisfy at least 'k' children
    }
}
