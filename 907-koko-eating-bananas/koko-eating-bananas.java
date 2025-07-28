class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int k = 0;
        for (int num : piles) {
            k = Math.max(num, k);
        }

        int l = 1;
        int r = k;
        int ans = k; // initialize to max, so we always store valid minimum

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int val = eating(piles, mid, h);

            if (val == 1 || val == 0) {
                ans = mid;
                r = mid - 1; // try to find smaller k
            } else if (val == 2) {
                l = mid + 1; // too slow, need faster
            }
        }
        return ans;
    }

    int eating(int[] piles, int k, int h) {
        long sum = 0;
        for (int num : piles) {
            sum += (num + k - 1) / k;
        }
        if (sum == h) return 1;
        if (sum > h) return 2;
        return 0;
    }
}
