class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int sym = 0;
        for (int i = low; i <= high; i++) {
            String digit = String.valueOf(i);
            int len = digit.length();

            // Check only even-length numbers
            if (len % 2 != 0) continue;

            int sumFirst = 0, sumSecond = 0;
            for (int j = 0; j < len / 2; j++) {
                sumFirst += digit.charAt(j) - '0';
                sumSecond += digit.charAt(j + len / 2) - '0';
            }

            if (sumFirst == sumSecond) {
                sym++;
            }
        }
        return sym;
    }
}
