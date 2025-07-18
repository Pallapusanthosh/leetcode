class Solution {
    public long minimumDifference(int[] nums) {
        int m = nums.length;
        int n = m/3;
        long[] leftsum = new long[m];
        long[] rightsum = new long[m];
        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();
        long sum = 0;
        for(int i = 0; i<m;i++){
          left.offer(nums[i]);
           sum += nums[i];
           if (left.size() > n) sum -= left.poll();
           leftsum[i] = left.size() == n ? sum : Long.MAX_VALUE;
        }
        long sum1 = 0;
        for(int i = m-1; i >=0; i --){
             right.offer(nums[i]);
             sum1 +=nums[i];
             if(right.size() > n) sum1 -=right.poll();
             rightsum[i] = right.size() == n ? sum1 : Long.MIN_VALUE;
        }
        long ans = Long.MAX_VALUE;
        for (int i = n - 1; i < 2 * n; i++) {
            long a = leftsum[i];
            long b = rightsum[i + 1];
            ans = Math.min(ans, a - b);
        }
        return ans;
    }
}