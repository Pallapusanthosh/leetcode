class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int count = 0;
        for(int j = 1 ; j<n-1;j++){
           int leftless = 0;
           int rightgreat = 0;

           int leftgreat = 0;
           int rightless =0;


           for(int i = 0; i<j;i++){
            if(rating[i] < rating[j]){
                leftless +=1;
            }
            if(rating[i] > rating[j]){
                leftgreat +=1;
            }
           }
           for(int  i= j+1;i<n;i++){
            if(rating[i] > rating[j]){
                rightgreat +=1;
            }
            if(rating[i] < rating[j]){
                rightless +=1;
            }
           }
           count +=leftless * rightgreat;
           count +=leftgreat * rightless;
        }
        return count;
    }
}