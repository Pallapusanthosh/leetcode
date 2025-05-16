class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        ArrayList<String> res = new ArrayList<>();
        if(words.length == 0){
            return res;
        }
        if(words.length == 1){
            res.add(words[0]);
            return res;
        }
        int key = groups[0];
        res.add(words[0]);
        for(int i = 1;i<groups.length;i++){
            if(groups[i]==key){
                continue;
            }
            res.add(words[i]);
            key = groups[i];
        }
        return res;
    }
}