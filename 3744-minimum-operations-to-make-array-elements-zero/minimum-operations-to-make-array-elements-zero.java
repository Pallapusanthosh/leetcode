class Solution {
    public long minOperations(int[][] queries) {
        long totalOps = 0;

        for (int[] q : queries) {
            totalOps += countOperations(q[0], q[1]);
        }

        return totalOps;
    }

    long countOperations(long l, long r) {
        long total = 0;
        long start = 1;
        int steps = 1;

        while (start <= r) {
            long end = start * 4 - 1;

            long left = Math.max(l, start);
            long right = Math.min(r, end);

            if (left <= right) {
                long count = right - left + 1;
                total += count * steps;
            }

            start *= 4;
            steps++;
        }

        return (total + 1) / 2; // ceil division for pairing
    }
}
