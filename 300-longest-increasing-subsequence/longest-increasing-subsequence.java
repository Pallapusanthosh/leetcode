class Solution {
    public int lengthOfLIS(int[] nums) {
      int n = nums.length;
      if(n == 1) return 1;
      if(n==0) return 0;
      ArrayList<Integer> ar = new ArrayList<>();
      ar.add(nums[0]);
      for(int i =1 ; i<n;i++){
      if(nums[i] > ar.get(ar.size() - 1)) {
            ar.add(nums[i]);
        }
        else{
            int low = 0;
            int high = ar.size();

            while (low < high) {
                int mid = low + (high - low) / 2;
                if (ar.get(mid) < nums[i]) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            ar.set(low,nums[i]);
        }
      }
      System.out.print(ar);
      return ar.size();
    }
}