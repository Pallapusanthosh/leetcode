class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int max_sum = 0;
        int cur_sum = 0;
        int l = 0;
        int r = 0;
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        while( l <= r && r < n){

            if(set.contains(nums[r])){
                while(nums[l] != nums[r] ){
                
                    cur_sum -=nums[l];
                    set.remove(nums[l]);
                    l++;
                }set.remove(nums[l]);
                cur_sum -=nums[l++];
                

            }
            set.add(nums[r]);
            cur_sum +=nums[r++];
           
            max_sum = Math.max(max_sum,cur_sum);
        }
     
        return max_sum;
    }
}