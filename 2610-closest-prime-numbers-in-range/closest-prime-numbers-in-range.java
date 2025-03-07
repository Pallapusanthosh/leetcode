import java.util.*;

class Solution {
    public int[] closestPrimes(int left, int right) {
        if (left > right) return new int[]{-1, -1}; // Invalid range
        
        boolean prime[] = new boolean[right + 1];
        Arrays.fill(prime, true);  // Mark all numbers as prime initially
        prime[0] = prime[1] = false; // 0 and 1 are not prime
        
        // Sieve of Eratosthenes
        for (int p = 2; p * p <= right; p++) {
            if (prime[p]) {
                for (int i = p * p; i <= right; i += p) {
                    prime[i] = false;
                }
            }
        }

        // Finding closest prime pair
        int prevPrime = -1, minDiff = Integer.MAX_VALUE;
        int[] res = {-1, -1};

        for (int i = left; i <= right; i++) {
            if (prime[i]) {
                if (prevPrime != -1 && (i - prevPrime) < minDiff) {
                    minDiff = i - prevPrime;
                    res[0] = prevPrime;
                    res[1] = i;
                }
                prevPrime = i;
            }
        }
        return res;
    }

}