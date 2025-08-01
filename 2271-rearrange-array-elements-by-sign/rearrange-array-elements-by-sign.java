class Solution {
    public int[] rearrangeArray(int[] nums) {
        int pos = 0;
        int neg = 1;
        int[] sol = new int[nums.length];
        for(int i =0;i<nums.length;i++){
            if(nums[i] > 0){
                sol[pos] = nums[i]; 
                pos +=2;;
            }
            else{
                sol[neg] = nums[i];
                neg +=2;
            }  
        }
        return sol;
    }
}