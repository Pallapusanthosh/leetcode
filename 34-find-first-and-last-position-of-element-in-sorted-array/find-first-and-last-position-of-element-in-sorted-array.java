class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        int n = nums.length;
        int l = 0;
        int h = n-1;
        while(l <= h){
            int mid = l + (h -l) /2;
            if(nums[mid] == target ){
                ans[0] = mid;
                h = mid-1;
            }
            if(nums[mid] < target){
                l = mid + 1;
            }else{
                h = mid -1;
            }
        }
         l = 0;
         h = n-1;
        while(l <= h){
            int mid = l + (h -l) /2;
            if(nums[mid] == target ){
                ans[1] = mid;
                l = mid+1;
            }
            else if(nums[mid] < target){
                l = mid + 1;
            }else{
                h = mid -1;
            }
        }
        return ans;
    }

}