class Solution {
    public int findKthPositive(int[] arr, int k) {
        //figure out the indexes first
        int l = 0;
        int n = arr.length;
        int h = n -1;

        while(l <= h){
            int mid = (l + h)/2;
           
            if(arr[mid] - (mid + 1) < k){
                l = mid +1;
            }
            else if(arr[mid] - (mid + 1) >= k){
                h = mid -1;
            }
        }
        //missing = ar[high] - (high + 1)
        //more = k - missing
        //ans = ar[high] + more
        //ans = ar[high] + k - ar[high] + high +1
        //ans = k + 1 + high
        //ans = k + low // since high +1 = low
        return l + k;
    }
}