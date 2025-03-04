class Solution {
    public boolean checkPowersOfThree(int n) {
        int[] threepower = new int[16];
        for(int i =0;i<16;i++){
            threepower[i] = (int) Math.pow(3,i);
        }
        List<Integer> res = new ArrayList<>();
        if(findSubset(threepower,0,n,res)){
            return true;
        }
        return false;

    }
     private static boolean findSubset(int[] nums, int index, int target, List<Integer> result) {
        if (target == 0) return true; // Found a valid subset

        for (int i = index; i < nums.length; i++) {
            if (nums[i] > target) break; // Prune if number is too large

            result.add(nums[i]); // Pick the number
            if (findSubset(nums, i + 1, target - nums[i], result)) return true; // Recur
            result.remove(result.size() - 1); // Backtrack
        }
        return false;
    }
}