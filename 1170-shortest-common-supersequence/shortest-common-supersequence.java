class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {

        if (str1.equals(str2)) {
            return str1;
        }

        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];

        // Step 1: Compute LCS Length
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }


        // Step 3: Reconstruct the Shortest Common Supersequence (SCS)
        StringBuilder scs = new StringBuilder();
        int i = m, j = n;

        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                scs.append(str1.charAt(i - 1)); // Include LCS character
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                scs.append(str1.charAt(i - 1)); // Include non-matching character from str1
                i--;
            } else {
                scs.append(str2.charAt(j - 1)); // Include non-matching character from str2
                j--;
            }
        }

        // Add remaining characters from str1 and str2
        while (i > 0) {
            scs.append(str1.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            scs.append(str2.charAt(j - 1));
            j--;
        }

        return scs.reverse().toString(); // Reverse because we built it backwards
    
}
    
}