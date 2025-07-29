class Solution {
    public int splitArray(int[] arr, int k) {
        //same as book allocation
         if(arr.length < k) return -1;
        int max_num = 0;
        int total = 0;
        for(int num : arr){
            max_num = Math.max(max_num,num);
            total +=num;
        }
        
        int l = max_num;
        int h = total;
        int n = arr.length;
        while(l <=h){
            int mid = l + (h - l) /2;
           
             
            if(allocate(mid,k,arr)){
                h = mid -1;
            }else{
                l = mid +1;
            }
        }
        return l;

    }
     boolean allocate(int mid , int k , int[] arr){
        int stu = 1;
        int stupages = 0;
        for(int i = 0; i<arr.length;i++){
            if(arr[i] + stupages <= mid){
                stupages +=arr[i];
            }else{
                stu +=1;
                stupages = arr[i];
            }
        }
        return stu <= k;
    }
}