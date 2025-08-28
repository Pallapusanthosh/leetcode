class Solution {
    public int characterReplacement(String s, int k) {
        //
        int l = 0;
        int r = 0;
        int n = s.length();
        int maxfeq = 0;
        int maxlen = 0;
        int[] hash = new int[26];
         while(r < n){
            hash[s.charAt(r)-'A']++;
            maxfeq = Math.max(maxfeq , hash[s.charAt(r)-'A']);

            while(r-l+1 - maxfeq > k){
                hash[s.charAt(l)-'A']--;
                for(int i = 0 ; i< 26 ; i++){
                    maxfeq = Math.max(maxfeq , hash[i]);
                }
                l++;
            }
            if(r-l+1 - maxfeq  <= k){
                maxlen = Math.max(maxlen , r-l + 1);
            }
            r++;
        }
        return maxlen;
    }
}