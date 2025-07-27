class Solution {
    public int countHillValley(int[] nums) {
    int count = 0;
    ArrayList<Integer> new_num = new ArrayList<>();
    int k= 0;
    while (k< nums.length) {
        new_num.add(nums[k]);
        int j = k+ 1;
        while (j < nums.length && nums[j] == nums[k]) {
            j++;
        }
        k= j;
    }
        System.out.println(new_num);
        int n = nums.length;
        for(int i= 1 ; i< new_num.size() -1;i++){
            if((new_num.get(i) > new_num.get(i-1) && new_num.get(i) > new_num.get(i+1)) ||
               (new_num.get(i) < new_num.get(i-1) && new_num.get(i) < new_num.get(i+1))){
                count +=1;
            }
        }
        return count;
    }
}