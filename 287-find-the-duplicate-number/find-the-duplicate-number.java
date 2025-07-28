class Solution {
    public int findDuplicate(int[] nums) {
        int low = 0;
        int n= nums.length;
        int high = n-1;
        while(low < high){
            int mid = (low + high )/2;
            int c = 0;
            for(int num:nums){
                if(num <= mid) c++;
            }
            if(c > mid){
                high = mid;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
}