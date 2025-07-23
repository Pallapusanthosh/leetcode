class Solution {
    public int maximumGain(String s, int x, int y) {
        return x >= y ? solve(s, 'a', 'b', x, y) : solve(s, 'b', 'a', y, x);
    }
    private int solve(String s, char a, char b, int hi, int lo) {
        int pts = 0;
        StringBuilder t = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == b && t.length() > 0 && t.charAt(t.length() - 1) == a) {
                t.setLength(t.length() - 1);
                //if we found a match ab we are adding points and setting the new length 
                pts += hi;
            } else t.append(c);
        }
        StringBuilder u = new StringBuilder();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (c == a && u.length() > 0 && u.charAt(u.length() - 1) == b) {
                u.setLength(u.length() - 1);
                pts += lo;
            } else u.append(c);
        }
        return pts;
    }
}
