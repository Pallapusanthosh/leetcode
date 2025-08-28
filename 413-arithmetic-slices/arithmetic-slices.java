class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int count = 0;
        for(int i = 0 ; i < nums.length ;i++){
            for(int j = i+2 ; j< nums.length ; j++){
                if(check(nums , i , j)){
                    // System.out.println(i + "" + j);
                    count +=1;
                }
            }
        }
        return count;
    }
    boolean check(int[] nums , int start , int end){
        int diff = nums[start+1] - nums[start];
        // boolean pos = true;
        for(int i = start+1 ; i < end ;i++){
            if(diff != nums[i + 1] - nums[i]){
                return false;
            }
        }
        return true;
      
    }
}