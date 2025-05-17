class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        List<String> res = new ArrayList<>();
        int lisend = 0;
        int[] lis = new int[n];
        Arrays.fill(lis, 1);
        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (groups[i] != groups[j] &&
                    words[i].length() == words[j].length() &&
                    hammingdistance(words[i], words[j])) {
                    if (lis[i] + 1 > lis[j]) {
                        lis[j] = lis[i] + 1;
                        parent[j] = i;
                        if (lis[j] > lis[lisend]) {
                            lisend = j;
                        }
                    }
                }
            }
        }

        int i = lisend;
        while (i != -1) {
            res.add(words[i]);
            i = parent[i];
        }

        Collections.reverse(res);
        return res;
    }

    public boolean hammingdistance(String s, String s1) {
        if (s.length() != s1.length()) return false;
        int dist = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s1.charAt(i)) {
                dist++;
            }
        }
        return dist == 1;
    }
}
