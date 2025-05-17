class Solution {
    public void sortColors(int[] nums) {
        if (nums.length == 1) return;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        
        int k = 0;
        for (int i = 0; i <= 2; i++) {
            int count = map.getOrDefault(i, 0);
            if(count == 0) continue;
            for (int j = 0; j < count; j++) {
                nums[k++] = i;
            }
        }
    }
}
