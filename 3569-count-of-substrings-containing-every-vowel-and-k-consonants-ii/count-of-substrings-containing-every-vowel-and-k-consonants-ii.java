import java.util.HashMap;

class Solution {
    public long countOfSubstrings(String word, int k) {
        return sub(word, k) - sub(word, k + 1);
    }

    public long sub(String word, int k) {
        int n = word.length();
        int left = 0, vowelCount = 0, consonantCount = 0;
        long count = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < n; right++) {
            char c = word.charAt(right);

            if (isVowel(c)) {
                map.put(c, map.getOrDefault(c, 0) + 1);
                if (map.get(c) == 1) vowelCount++;  // New distinct vowel found
            } else {
                consonantCount++;
            }

            // Shrink the window if conditions exceed requirements
            while (vowelCount == 5 && consonantCount >= k) {
                count += n - right; // All substrings starting here are valid
                char leftChar = word.charAt(left++);

                if (isVowel(leftChar)) {
                    map.put(leftChar, map.get(leftChar) - 1);
                    if (map.get(leftChar) == 0) vowelCount--;  // Remove vowel if count becomes zero
                } else {
                    consonantCount--;
                }
            }
        }

        return count;
    }

    public boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }
}
