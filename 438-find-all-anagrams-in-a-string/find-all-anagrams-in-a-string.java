import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int len1 = s.length(), len2 = p.length();
        if (len1 < len2) return new ArrayList<>();

        List<Integer> ans = new ArrayList<>();
        int[] pmap = new int[26];
        int[] smap = new int[26];

        // Build frequency map for p
        for (int i = 0; i < len2; i++) {
            pmap[p.charAt(i) - 'a']++;
            smap[s.charAt(i) - 'a']++;  // Initial window
        }

        // Compare initial window
        if (Arrays.equals(pmap, smap)) {
            ans.add(0);
        }

        // Slide the window
        for (int i = len2; i < len1; i++) {
            smap[s.charAt(i) - 'a']++;            // Add new char
            smap[s.charAt(i - len2) - 'a']--;     // Remove old char

            if (Arrays.equals(pmap, smap)) {
                ans.add(i - len2 + 1);            // Add correct index
            }
        }

        return ans;
    }
}