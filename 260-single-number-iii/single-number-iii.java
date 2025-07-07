class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) xor ^= num;

        int rightmostbit = xor & (-xor);  // isolate rightmost set bit

        int b1 = 0, b2 = 0;
        for (int num : nums) {
            if ((num & rightmostbit) != 0) {
                b1 ^= num;
            } else {
                b2 ^= num;
            }
        }
        return new int[]{b1, b2};
    }
}
