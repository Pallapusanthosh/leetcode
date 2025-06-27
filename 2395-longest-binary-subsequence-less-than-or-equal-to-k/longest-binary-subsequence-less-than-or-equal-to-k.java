import java.math.BigInteger;

class Solution {
    public int longestSubsequence(String s, int k) {
        BigInteger k1 = BigInteger.valueOf(k);
        BigInteger number = new BigInteger(s, 2);
        
        if (number.compareTo(k1) <= 0) {
            return s.length();
        }

        StringBuilder sb = new StringBuilder(s);
        
        for (int i = 0; i < sb.length(); ) {
            if (sb.charAt(i) == '1') {
                String candidate = sb.substring(0, i) + sb.substring(i + 1);
                BigInteger temp = new BigInteger(candidate, 2);

                if (temp.compareTo(k1) <= 0) {
                    return candidate.length();
                }

                sb.deleteCharAt(i);  // remove '1'
            } else {
                i++;  // only increment if no deletion
            }
        }

        return 0;
    }
}
