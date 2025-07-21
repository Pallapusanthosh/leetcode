class Solution {
    public int numDecodings(String s) {
        int[] memo = new int[s.length()];
        Arrays.fill(memo , -1);
        return dfs(0, s , memo);
    }
    int dfs(int i, String s , int[] memo) {
        int n = s.length();
        if (i == n) return 1;
        if(memo[i]!=-1) return memo[i];
        if (s.charAt(i) == '0') return memo[i] = 0;
        int res = dfs(i + 1, s , memo);
        if (i + 1 < n && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) <= '6')))
            res += dfs(i + 2, s , memo);
        return memo[i] = res;
    }
}
