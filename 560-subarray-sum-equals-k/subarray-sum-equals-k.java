class Solution {
    public int subarraySum(int[] nums, int k) {
        int prefixsum = 0;
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i =0;i<nums.length;i++){
            prefixsum += nums[i];
            // count +=1;
            int remove = prefixsum -k;
            if(map.containsKey(remove)){
                count += map.get(remove);   
            }
            map.put(prefixsum,map.getOrDefault(prefixsum,0)+1);
        }
        return count;
    }
}