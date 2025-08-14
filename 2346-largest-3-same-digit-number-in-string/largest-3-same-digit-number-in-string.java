class Solution {
    public String largestGoodInteger(String num) {
        // String sol;
        int sol = -1;
        for(int i = 0; i< num.length() -2;i++){
            if(num.charAt(i) == num.charAt(i+1) && num.charAt(i) == num.charAt(i+2)){
                int num1 =(int) num.charAt(i) -'0';
               sol = Math.max(sol , Integer.parseInt("" + num1 +""+ num1 +"" + num1  ));
            }
        }
        if(Integer.toString(sol).equals("0")){
            return "000";
        }else if(sol == -1){
            return "";
        }
        return Integer.toString(sol);
    }
}