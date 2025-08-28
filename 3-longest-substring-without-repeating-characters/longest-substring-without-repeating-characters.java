class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxlen = 1;
        // for(int i = 2; i<s.length();i++){
        //     for(int j =0;j<s.length()-i;j++){
        //         if(check(j,i,s)){
        //             count +=Math.max(count , i);
        //         }
        //     }
        // }
        int n = s.length();
        if(n == 0) return 0;
        int l = 0 ;
        int r = 0;
        HashMap<Character , Integer> map = new HashMap<>();
        
        while(r  < n){
            if(map.containsKey(s.charAt(r))){
                if(map.get(s.charAt(r)) >= l){
                    l = map.get(s.charAt(r)) + 1;
                }
                
                map.put(s.charAt(r),r);
            }else{
                map.put(s.charAt(r) , r);
            }
            maxlen = Math.max(maxlen , r - l + 1);
            r++;
        }
        return maxlen;
    }
    public boolean check(int start , int end,String s){
        String substr = s.substring(start,end);
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0 ; i<substr.length();i++){
            if(map.containsKey(s.charAt(i))){
              return false;
            }map.put(s.charAt(i),1);
        }return true;
    }
}