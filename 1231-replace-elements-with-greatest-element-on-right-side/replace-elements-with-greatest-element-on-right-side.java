class Solution {
    public int[] replaceElements(int[] arr) {
        int max = -1;
        int n = arr.length;
        for(int i = n-1;i>-1;i--){
            int val = arr[i];
            arr[i] = max;
            max = Math.max(max,val);
        }
        return arr;
    }
}