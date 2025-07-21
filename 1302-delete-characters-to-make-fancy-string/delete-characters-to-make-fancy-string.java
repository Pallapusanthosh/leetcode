class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        char con_char = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == con_char) {
                if (count < 2) sb.append(c);
                //skipping the 3rd consective elements
                count++;
            } else {
                con_char = c;
                count = 1;
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
