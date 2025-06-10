class Solution {
    public int maxDifference(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i= 0; i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        System.out.print(map);
        int odd_max = -1;
        int even_min = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
             if(entry.getValue() %2==0){
                System.out.print("even");
               even_min = Math.min(even_min,entry.getValue());
             }else{
               odd_max = Math.max(odd_max,entry.getValue());
             }
        }
        System.out.print(odd_max);
        System.out.print(even_min);
        return odd_max - even_min;
    }
}