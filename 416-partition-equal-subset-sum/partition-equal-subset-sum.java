class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) sum += num;
        if(sum % 2 != 0) return false;
        int target = sum /2;
        //here we need to calculate the sum / 2 sice it is main set is dividing into equal subsets if we can find a set with sum sum/2 we can return true;
        int n = nums.length;
        boolean[][] memo = new boolean[n + 1][target + 1];
        // boolean ans = dp(n-1,target , nums , memo);
        // for(int i = 0 ; i<n;i++){
        //     for(int j = 0; j<target;j++){
        //         System.out.print(memo[i][j]);
        //     }System.out.println();
        // }
        // return ans;
        return dpbp(n , target , nums);
    }
    // boolean dp(int i , int target ,int[] nums ,boolean[][] memo ){

    //     //base cases;
    //     // System.out.println(i + " " + target);
    //     if(memo[i][target]) return true;
    //     if(i == 0){
    //         if(nums[i] == target){
    //             memo[i][target] = true;
    //         return true;
    //         }else{
    //             memo[i][target] = false;
    //             return false;
    //         }
    //     }
    //     if(target == 0){
    //         memo[i][target] = true;
    //         return true;
    //     }

    //     boolean take = false;
    //     if(nums[i] <= target){
    //         take = dp(i-1, target - nums[i] , nums ,memo);
    //     }
    //     boolean nottake = dp(i-1,target , nums , memo);
    //     memo[i][target] = take || nottake; 
    //     return  memo[i][target];
    // }
    boolean dpbp(int n ,int target , int[] nums){
       boolean dp[][]  = new boolean[n+1][target+1];
       //target = 0;
       for(int i = 0 ; i<n;i++)dp[i][0] = true;
       for(int i = 0 ; i <= target;i++){
          if(nums[0] == i){
            dp[0][i] = true;
          } else{
            dp[0][i] = false;
          }
       }

        for(int i = 1; i<n;i++){
            for(int j = 1; j<=target ; j++){
                boolean take = false;
                if(nums[i] <= j){
                    take = dp[i-1][j- nums[i]];
                }
                boolean nottake = dp[i-1][j];
                dp[i][j] = take || nottake; 
            }
        }
        return dp[n-1][target];

    }
}