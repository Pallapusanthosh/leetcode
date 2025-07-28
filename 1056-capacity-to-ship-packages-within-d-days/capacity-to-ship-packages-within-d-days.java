class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int l = 1;
        int max1 = 0;
        for(int num : weights){
            max1 = Math.max(num , max1);
        }
    int h = (int)((long)max1 * n);
    int ans = 0;
        while(l <= h){
            int mid = l + (h -l) /2;
         
            if(checkday(weights,mid,days)){
                // ans = h;
                h = mid -1;   
            }
            else{
                l = mid +1;
            }
        }
       
        return l;
    }
    boolean checkday(int[] weights ,int capacity , int days){
        int sum = 0;
        int day = 1;
        for(int i = 0;i<weights.length;i++){
            if(weights[i] > capacity) return false;
            if(sum + weights[i] > capacity){
                day +=1;
                sum = weights[i];
            }else{

            sum += weights[i]; 
            }
        }
        return day <= days;
    }
  


}