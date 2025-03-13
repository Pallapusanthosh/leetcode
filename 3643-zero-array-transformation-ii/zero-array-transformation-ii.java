class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        if(isZeroArray(nums)){
            return 0;
        }
        int left = 0, right = queries.length, result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int[] temp = Arrays.copyOf(nums, nums.length);
            int[] diff = new int[nums.length + 1];

            for (int i = 0; i < mid; i++) {
                int li = queries[i][0];
                int ri = queries[i][1];
                int vali = queries[i][2];

                diff[li] -= vali;
                if (ri + 1 < nums.length) diff[ri + 1] += vali;
            }

            // Apply the prefix sum to update the array
            int sum = 0;
            for (int i = 0; i < temp.length; i++) {
                sum += diff[i];
                temp[i] = Math.max(0, temp[i] + sum);
            }

            if (isZeroArray(temp)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result == 0 ? -1 : result;
    }

    public static boolean isZeroArray(int[] nums) {
        for (int num : nums) {
            if (num != 0) return false;
        }
        return true;
    }

    
}