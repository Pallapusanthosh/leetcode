class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 1;
        int n = nums.length;
        int r = n - 2;

        if (n == 1) return nums[0];
        if (nums[0] != nums[1]) return nums[0];
        if (nums[n - 1] != nums[n - 2]) return nums[n - 1];

        while (l <= r) {
            int m = (l + r) / 2;

            // Correct condition to find the unique one
            if (nums[m] != nums[m - 1] && nums[m] != nums[m + 1]) {
                return nums[m];
            }

            // Fixing the parity logic (based on index)
            if ((m % 2 == 0 && nums[m] == nums[m + 1]) ||
                (m % 2 == 1 && nums[m] == nums[m - 1])) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }
}
