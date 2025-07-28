import java.util.*;

class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;
        for (int num : nums) {
            maxOr |= num;
        }
        Map<String, Integer> memo = new HashMap<>();
        return dfs(0, 0, nums, maxOr, memo);
    }

    int dfs(int i, int curOr, int[] nums, int maxOr, Map<String, Integer> memo) {
        if (i == nums.length) {
            return curOr == maxOr ? 1 : 0;
        }

        String key = i + "," + curOr;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // Include nums[i]
        int include = dfs(i + 1, curOr | nums[i], nums, maxOr, memo);
        // Exclude nums[i]
        int exclude = dfs(i + 1, curOr, nums, maxOr, memo);

        int total = include + exclude;
        memo.put(key, total);
        return total;
    }
}
