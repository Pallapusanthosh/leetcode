class Solution {
    public int[] sumZero(int n) {
        int mid = n/2;
        int[] ans = new int[n];
        int val = -mid;
        int i = 0;
        int j =0;
        if(n%2 == 0 ){

            while(i < n){
            ans[i] = val;
            val++;
            if(val == 0) val++;
            i++;
        }
        }
        else{
             while(j < n){
            ans[j] = val;
            val++;
            j++;
        }
        }
        
        return ans;
    }
}