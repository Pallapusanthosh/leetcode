import java.util.*;

class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int lessCount = 0, pivotCount = 0, greatCount = 0;
        
        for (int num : nums) {
            if (num < pivot) lessCount++;
            else if (num > pivot) greatCount++;
            else pivotCount++;
        }

        int[] less = new int[lessCount];
        int[] great = new int[greatCount];

        int l = 0, g = 0;
        for (int num : nums) {
            if (num < pivot) less[l++] = num;
            else if (num > pivot) great[g++] = num;
        }

        int[] result = new int[nums.length];
        int k = 0;
        for (int num : less) result[k++] = num;
        while (pivotCount-- > 0) result[k++] = pivot;
        for (int num : great) result[k++] = num;
        
        return result;
    }
}
