class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        //it is same binary arra with a goal == k
        int bin[] = new int[nums.length];
        for(int i =0 ; i<nums.length;i++){
            if(nums[i]%2 == 0){
                bin[i] = 0;
            }else{
                bin[i] = 1;
            }
        }
        return f(bin , k) - f(bin , k-1);

    }
     int f(int[] nums , int goal){
        if(goal < 0) return 0;
        int l = 0;
        int r = 0;
        int n = nums.length;
        int count = 0;
        int sum =0;
        while(r < n){
            sum += nums[r];
            while(sum > goal){
                sum -=nums[l];
                l++;
            }
            count += (r-l + 1);
            r++;
        }
        return count;
    }
}