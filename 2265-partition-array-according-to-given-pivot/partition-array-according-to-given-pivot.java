import java.util.*;

class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        Queue<Integer> s1 = new LinkedList<>();
        Queue<Integer> s2 = new LinkedList<>();
        int pivot_counter = 0;

        // Separate elements into two queues and count pivot occurrences
        for (int num : nums) {
            if (num > pivot) {
                s1.add(num);
            } else if (num < pivot) {
                s2.add(num);
            } else {
                pivot_counter++;
            }
        }

        int[] result = new int[nums.length];
        int k = 0;

        // Add smaller elements
        while (!s2.isEmpty()) {
            result[k++] = s2.poll();
        }

        // Add pivot occurrences
        while (pivot_counter > 0) {
            result[k++] = pivot;
            pivot_counter--;
        }

        // Add larger elements
        while (!s1.isEmpty()) {
            result[k++] = s1.poll();
        }

        return result;
    }
}
