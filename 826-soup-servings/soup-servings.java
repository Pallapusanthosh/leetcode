class Solution {
    public double soupServings(int n) {
        if(n > 5000) return 1.0;
        HashMap<String,Double> map = new HashMap<>();
        return dp((double)n,(double)n,map);
    }
    double dp(double a , double b , HashMap<String,Double> map){
        String key = a + "," + b;
        if(map.get(key)!=null){
            return map.get(key);
        }
        if(a <= 0 && b>0){
            map.put(key,(double)1);
            return 1;
        }
        else if(a <= 0 && b <=0){
            map.put(key,(double)0.5);
            return 0.5;
        }
        else if(b <= 0 && a > 0){
            map.put(key,(double)0);
            return 0;
        }

        double op1 = dp(a -100 , b-0,map);
        double op2 = dp(a - 75, b-25,map);
        double op3 = dp(a -50 , b-50,map);
        double op4 = dp(a-25 , b-75,map);

        double probsum = op1 + op2 + op3 + op4;
        map.put(key,(double)probsum/4);
        return probsum/4;
    }
}