class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        // +ve means right direction and viceversa
        int n = asteroids.length;
        ArrayDeque<Integer> st = new ArrayDeque<>();
        for(int i = 0 ; i<n; i++ ){
            if(asteroids[i] > 0){
                st.push(asteroids[i]);
            }else{
                while(!st.isEmpty() && st.peek() > 0  &&  st.peek() < Math.abs(asteroids[i])){
                    st.pop();
                }
                if(!st.isEmpty() && st.peek() == Math.abs(asteroids[i])){
                    st.pop();
                }
                else if(st.isEmpty() || st.peek() < 0){
                    st.push(asteroids[i]);
                }

            }
        }
        int[] ans = new int[st.size()];
        int k = st.size() - 1;
        for(int x : st){
            ans[k] = st.pop();
            k--; 
        }
        return ans;
    }
}