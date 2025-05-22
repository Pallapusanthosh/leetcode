class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n <= 1) return s;

        boolean[][] mat = new boolean[n][n];
        int max_len = 1;
        int start = 0;

        // All substrings of length 1 are palindromes
        for (int i = 0; i < n; i++) {
            mat[i][i] = true;
        }

        // Check substrings of length 2
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                mat[i][i + 1] = true;
                start = i;
                max_len = 2;
            }
        }

        // Check substrings of length >= 3
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && mat[i + 1][j - 1]) {
                    mat[i][j] = true;
                    start = i;
                    max_len = len;
                }
            }
        }

        return s.substring(start, start + max_len);
    }
}
