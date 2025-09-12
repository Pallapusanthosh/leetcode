class Solution {
    public boolean doesAliceWin(String s) {
        int count = 0;
        for(char c : s.toCharArray()){
            if("aeiou".indexOf(c)!=-1){
                return true;
            }
        }return false;
    }
}