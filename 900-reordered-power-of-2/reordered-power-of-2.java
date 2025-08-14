class Solution {
    public boolean reorderedPowerOf2(int n) {
        String target = sortedString((double)n);
        for (int i = 0; i < 31; i++) {
            if(sortedString((double)Math.pow(2 , i)).equals(target)) return true;
            // if (sortedString(1 << i).equals(target)) return true;
        }
        return false;
    }

    private String sortedString(double x) {
        //used to convert string
        char[] arr = String.valueOf(x).toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}