class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n= bloomDay.length;
        if(n < (long)m * k)  return -1;
        int min_1 = Integer.MAX_VALUE;;
        int max_1 = 0;
        for (int num : bloomDay) {
            max_1 = Math.max(num, max_1);
            min_1 = Math.min(num, min_1);
        }
        int l = min_1;
        int r = max_1;
        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if(testingday(bloomDay,mid,m,k)){
                r = mid -1;
            }else{
                l = mid + 1;
            }  
        }
        return l;
    }
boolean testingday(int[] bloom, int day , int m ,int k) {
        int count = 0;
        int boque = 0;
        for (int num : bloom) {
            if (num <= day) {
                count++;
                if (count == k) {
                    boque++;
                    count = 0;
                }
            } else {
                count = 0;
            }
        }
        
        return boque >= m;
    }
}
