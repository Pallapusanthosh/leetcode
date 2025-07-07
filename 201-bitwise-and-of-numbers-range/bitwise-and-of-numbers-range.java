class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;
        while(left < right){
            left >>= 1;
            right >>=1;
            shift++;
        }
        //here we comapare the left and right upto same no of bits means these are the bits that remain unchnaged means after doing n  & operations the ans remains same but the number is reduced so use shift counter to get back to the original number by left shifting
        return left << shift;
    }
}