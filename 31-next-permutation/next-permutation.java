class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int ind = -1;

        // Step 1: Find the break point
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                ind = i;
                break;
            }
        }

        // Step 2: If no break point, reverse the whole array
        if (ind == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        // Step 3: Find the next greater element from the end and swap
        for (int i = n - 1; i > ind; i--) {
            if (nums[i] > nums[ind]) {
                int temp = nums[i];
                nums[i] = nums[ind];
                nums[ind] = temp;
                break;
            }
        }

        // Step 4: Reverse the suffix
        reverse(nums, ind + 1, n - 1);
    }

    void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
