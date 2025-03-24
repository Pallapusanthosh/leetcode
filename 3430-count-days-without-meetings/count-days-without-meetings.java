import java.util.*;

class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        int count = 0;
        int lastEnd = 0;

        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];

            if (start > lastEnd + 1) {
                count += start - lastEnd - 1;
            }
            lastEnd = Math.max(lastEnd, end);
        }

        if (lastEnd < days) {
            count += days - lastEnd;
        }

        return count;
    }
}
