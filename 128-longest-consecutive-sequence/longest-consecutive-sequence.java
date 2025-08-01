class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int start = -1;
        int maxlen = 1;
        int count = 0;
        //store all values in a set and find a start ele if found consider counting ele + 1 and update maxlen
        for (int element : set) {
                if(!set.contains(element -1)){
                    start = element;
                    count =1;
                    int ele = element;
                    while(set.contains(ele +1)){
                        count +=1;
                        ele +=1;
                    }
                    maxlen = Math.max(maxlen,count);
                }
        }

        return maxlen;

    }
}