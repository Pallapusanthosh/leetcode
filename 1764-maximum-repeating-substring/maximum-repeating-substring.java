class Solution {
    public int maxRepeating(String sequence, String word) {
    int k = 0;
    StringBuilder repeated = new StringBuilder(word);
    while (sequence.contains(repeated.toString())) {
        k++;
        repeated.append(word);
    }
    return k;
    }
}