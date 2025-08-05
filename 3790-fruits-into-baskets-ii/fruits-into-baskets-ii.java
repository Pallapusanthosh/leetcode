class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int placed = 0;
        int n = fruits.length;
        for(int i = 0; i<n;i++){
            for(int j = 0 ; j<n;j++){
                if(baskets[j]!=-1){
                    if(fruits[i] <= baskets[j]){
                        baskets[j] = -1;
                        placed ++;
                        break;
                    }
                }
            }
        }
        return n - placed;
    }
}