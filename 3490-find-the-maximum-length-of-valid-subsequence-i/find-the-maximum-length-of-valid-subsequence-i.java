class Solution {
    public int maximumLength(int[] nums) {
        int odd = 0;
        int even = 0;
    
        if(nums[0] %2 ==0){
            even+=1;
        }
        else{
            odd+=1;
        }
        int maxlen = 1;
        for(int i = 1; i<nums.length;i++){
            if(nums[i] % 2 == 0){
                even +=1;
            }
            else{
                odd +=1;
            }
            if((nums[i] %2) != (nums[i-1]%2)){
                maxlen +=1;
            }
        }

        return Math.max(even,Math.max(odd,maxlen));

    }
}