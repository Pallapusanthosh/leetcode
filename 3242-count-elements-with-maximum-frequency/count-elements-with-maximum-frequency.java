class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] hash = new int[101];
        int max_freq = 0;
        for(int i = 0 ; i<nums.length ;i++){
            hash[nums[i]] = hash[nums[i]]  +1;
            max_freq = Math.max(max_freq , hash[nums[i]]);
        }
        int ct = 0;
        for(int i = 0 ; i<101;i++){
            if(hash[i] == max_freq){
                ct +=1;
            }
        }
        return max_freq * ct;
    }
}