import java.util.*;

class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int count = 0;

        // Traverse the array
        for (int i = 0; i <= n - 3; i++) {
            if (nums[i] == 0) {  // Flip if the current element is 0
                flip(nums, i);
                count++;
            }
        }

        // Check if the array is all 1s
        for (int num : nums) {
            if (num == 0) {
                return -1;  // Impossible to convert fully to 1s
            }
        }

        return count;
    }

    public void flip(int[] nums, int start) {
        for (int i = start; i < start + 3; i++) {
            nums[i] = nums[i] == 0 ? 1 : 0;
        }
    }
}
