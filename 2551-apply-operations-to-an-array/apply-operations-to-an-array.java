class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        int i = 0;
        while(i<n-1){
            if(nums[i] == nums[i+1]){
                nums[i] *=2;
                nums[i+1] = 0;
                i++;
            }
            i++;
        }
        int count =0;
        List<Integer> ar = new ArrayList<>();
        for(int num:nums){
            if(num!=0){
                ar.add(num);
            }
            else{
                count+=1;
            }
            
        }
        while(count > 0){
            ar.add(0);
            count -=1;
        }
        int[] result = new int[ar.size()];
        int l =0;
        for(int num:ar){
            result[l] = num;
            l++;
        }
        return result;
        
    }
}