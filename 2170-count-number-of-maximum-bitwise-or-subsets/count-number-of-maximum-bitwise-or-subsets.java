class Solution {
    public int count = 0;

    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;

        for (int num : nums) {
            maxOr |= num;
        }


        backtrack(0, 0, nums, maxOr);
        return count;
    }

    void backtrack(int index, int currentOr, int[] nums, int maxOr) {
        if (index == nums.length) {
            if (currentOr == maxOr) {
                count++;
            }
            return;
        }

        backtrack(index + 1, currentOr | nums[index], nums, maxOr);

        backtrack(index + 1, currentOr, nums, maxOr);
    }
}
