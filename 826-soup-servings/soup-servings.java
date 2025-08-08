class Solution {
    int[][] ops = {{4,0},{3,1},{2,2},{1,3}};
    public double soupServings(int n) {
        if (n > 5000) return 1.0; // Large n shortcut
        int m = (n + 24) / 25; // scale down to 25 ml units
        return dp(m, m, new HashMap<>());
    }

    double dp(int a, int b, HashMap<String, Double> memo) {
        String key = a + "," + b;
        if (memo.containsKey(key)) return memo.get(key);

        if (a <= 0 && b <= 0) return 0.5;
        if (a <= 0) return 1.0;
        if (b <= 0) return 0.0;

        double sum = 0.0;
        for (int[] op : ops) {
            sum += dp(a - op[0], b - op[1], memo);
        }
        sum /= 4.0;
        memo.put(key, sum);
        return sum;
    }
}
