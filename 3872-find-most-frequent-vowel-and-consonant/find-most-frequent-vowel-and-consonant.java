class Solution {
    public int maxFreqSum(String s) {
        int[] charscount = new int[26];

        int vow_feq = -1;
        int consonant_feq= -1;

        for(char c : s.toCharArray()){
            charscount[c-'a']++;
        }
        //vowel_max_count
        for(int i = 0 ; i < 26 ;i++){
            if(i == 0 || i == 4 || i == 8 || i ==14 || i == 20){
                if(vow_feq < charscount[i]){
                    vow_feq = charscount[i];
                }
            }else{
                if(consonant_feq < charscount[i]){
                    consonant_feq = charscount[i];
                }
            }
        }
        return vow_feq + consonant_feq;
    }
}