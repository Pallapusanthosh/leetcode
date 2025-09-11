import java.util.*;

class Solution {
    public String sortVowels(String s) {
        char[] t = new char[s.length()];
        ArrayList<Character> vowelsList = new ArrayList<>();
        int i = 0;
        
        // Step 1: Extract vowels and mark positions with '$'
        for (char c : s.toCharArray()) {
            if ("aeiouAEIOU".indexOf(c) != -1) {
                vowelsList.add(c);
                t[i] = '$';
            } else {
                t[i] = c;
            }
            i++;
        }
        
        // Step 2: Sort vowels
        char[] vowels = new char[vowelsList.size()];
        for (int k = 0; k < vowelsList.size(); k++) {
            vowels[k] = vowelsList.get(k);
        }
        Arrays.sort(vowels);
        
        // Step 3: Put sorted vowels back into their positions
        int j = 0;
        for (int k = 0; k < t.length; k++) {
            if (t[k] == '$') {
                t[k] = vowels[j++];
            }
        }
        
        return new String(t);
    }
}
