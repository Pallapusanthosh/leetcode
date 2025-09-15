class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] words = text.split(" ");
        int count = 0;
        for(String word : words){
            if(check(word,brokenLetters)){
                count +=1;
            }
        }
        return count;
    }
    boolean check(String word , String letters){
        for(char c: letters.toCharArray()){
            if(word.indexOf(c)!=-1){
                return false;
            }
        }
        return true;
    }
}