class Solution {
    public int[] nextGreaterElements(int[] nums) {
        //we use nextgretaerele single array conecpt but enlarge the array
        int n = nums.length;
        if(n == 1) return new int[]{-1};
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 2 * (n -1); i >= 0 ; i--){
            int num = nums[i % n];
            while(!st.isEmpty() && st.peek() <= num) {
                st.pop();
            }
            if(i < n) {
                ans[i] = st.isEmpty() ? -1 : st.peek();
            }
            st.push(num);
        }
        return ans;
    }
}