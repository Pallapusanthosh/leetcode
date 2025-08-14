class Solution {
    public String largestGoodInteger(String num) {
        // String sol;
        int sol = -1;
        int i = 0;
        while(i < num.length() -2){
            if(num.charAt(i) == num.charAt(i+1) && num.charAt(i) == num.charAt(i+2)){
                int x = num.charAt(i) - '0';
                int ans = 100 * x + 10 * x + x;
                if(ans > sol) sol = ans;
               
                i++;
            }
            i++;
        }
       
        if(sol == 0){
            return "000";
        }else if(sol == -1){
            return "";
        }else{
            return String.valueOf(sol);
        }
        
    }
}