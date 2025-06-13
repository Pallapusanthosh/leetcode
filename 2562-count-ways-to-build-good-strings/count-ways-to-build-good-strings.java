class Solution {
    int MOD = 1_000_000_007;

    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] memo = new int[high + 1];
        Arrays.fill(memo , -1);
        return f(0, low, high, zero, one,memo);
    }

    public int f(int len, int low, int high, int zero, int one, int[] memo) {
        if (len > high) return 0;
        if(memo[len]!=-1) return memo[len];

        int count = 0;

        if (len >= low) count = 1; // valid "good" string

        count = (count + f(len + zero, low, high, zero, one , memo)) % MOD;
        count = (count + f(len + one, low, high, zero, one , memo)) % MOD;

        return memo[len] = count;
    }
}
