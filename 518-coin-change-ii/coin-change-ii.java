class Solution {
      
    public int change(int amount, int[] coins) {
        int[][] memo = new int[coins.length+1][amount+1];
        
       
        for (int i = 0; i <= coins.length; i++) {
            memo[i][0] = 1;
        }
        for(int i = 1 ; i <= coins.length ; i++){
            for(int j = 1 ; j<amount+1 ; j++){
                int nottake = memo[i-1][j];
                int take =0;
                if(coins[i-1] <= j){
                        take =  memo[i][j-coins[i-1]];
                }
                memo[i][j] = take + nottake;
            }
        }
    
        return memo[coins.length ][amount];
    }
  
}