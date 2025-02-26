class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int res = nums[0];
        int res1 = nums[0];
        int maxEnding = nums[0];
        int minEnding = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxEnding = Math.max(maxEnding + nums[i], nums[i]);
            minEnding = Math.min(minEnding + nums[i],nums[i]);
            res = Math.max(res, maxEnding);
            res1 = Math.min(res1,minEnding);
        }
        
        return Math.max(res,Math.abs(res1));
    }
}