class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        StringBuilder result = new StringBuilder();

        
        if ((numerator < 0) ^ (denominator < 0)) result.append("-");

        long n = Math.abs((long) numerator);
        long d = Math.abs((long) denominator);

        // integer part
        result.append(n / d);
        //checking decimal part
        n %= d;
        if (n == 0) return result.toString(); 

        result.append(".");
        //decimal ans
        Map<Long, Integer> remainderMap = new HashMap<>();
        while(n!=0){
              if (remainderMap.containsKey(n)) {
                int start = remainderMap.get(n);
                result.insert(start, "(");
                result.append(")");
                break;
            }
            remainderMap.put(n,result.length());
            n *=10;
            result.append(n/d);
            n %=d;
        }
        return result.toString();
    }
}