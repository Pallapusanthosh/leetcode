class Solution {
    public boolean checkPowersOfThree(int n) {
        int rem;
        while(n >= 3){
            rem = n%3;
            n = n/3;
            if(rem!=0 && rem!=1){
                return false;
            }
        }
        if(n == 0 || n == 1){
            return true;
        }
        return false;
    }
}