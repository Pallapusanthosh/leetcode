class Solution {
      
    public int change(int amount, int[] coins) {
        int[][] memo = new int[coins.length][amount+1];
        
        for(int i = 0 ; i < coins.length ; i++){
            for(int j = 0 ; j<amount+1 ; j++){
                memo[i][j] = -1;
            }
        }
        
        return f(coins.length -1 , amount , coins , memo);
    }
    public int f(int n , int a,int[] coins ,int[][] memo){
        if(a == 0){
            return 1;
        }
        if(n < 0) return 0;
        if(memo[n][a]!=-1) return memo[n][a];
        // if(coins[n] > a) return;

        int nottake = f(n-1,a,coins,memo);
        int take =0;
        if(coins[n] <= a){
             take =  f(n,a-coins[n],coins,memo);
        }
        return memo[n][a] = take + nottake;
    }
}