class Solution {
    public int[] getNoZeroIntegers(int n) {
        int[] sol = new int[2];
        for(int i =1; i<=n ;i++){
            if(check(i , n-i)){
                sol[0] = i;
                sol[1] = n-i;
            }
        }
        return sol;
    }
    boolean check(int num1 ,int num2){
        String s1 = String.valueOf(num1);
        String s2 = String.valueOf(num2);
        if(s1.contains("0") || s2.contains("0")) return false;
        return true;
    }
}