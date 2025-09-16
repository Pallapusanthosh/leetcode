import java.util.*;

class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        for (int num : nums) {
            while (!ans.isEmpty()) {
                int last = ans.get(ans.size() - 1);
                int g = gcd(last, num);

                if (g == 1) break;

                num = lcm(last, num);
                ans.remove(ans.size() - 1);
            }
            ans.add(num);
        }

        return ans;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }

    private int lcm(int a, int b) {
        return Math.abs(a / gcd(a, b) * b);
    }
}
