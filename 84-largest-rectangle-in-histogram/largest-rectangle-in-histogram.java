class Solution {
    public int largestRectangleArea(int[] heights) {
        //find nextsmaller ele and prev smaller ele
        int[] nse = nextse(heights);
        int[] pse = prevse(heights);
        
        int maxi = -1;
        for(int i = 0 ; i<heights.length ; i++){
            maxi = Math.max(maxi , heights[i] * (nse[i] - pse[i] - 1));
        }
        return maxi;
    }
    int[] prevse(int[] h){
        int[] p = new int[h.length];
         ArrayDeque<Integer> st = new ArrayDeque<>();
        for(int i = 0; i<h.length;i++){
            while(!st.isEmpty() && h[st.peek()] >= h[i]){
                st.pop();
            }
            p[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return p;
    }
    int[] nextse(int[] h){
        int[] n = new int[h.length];
        ArrayDeque<Integer> st = new ArrayDeque<>();
        for(int i = h.length - 1 ; i >=0  ; i--){
            while(!st.isEmpty() && h[st.peek()] >= h[i]){
                st.pop();
            }
            n[i] = st.isEmpty() ? h.length : st.peek();
            st.push(i);
        }
        return n;
    }
}