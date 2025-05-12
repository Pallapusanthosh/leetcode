class Solution {
    public int[] findEvenNumbers(int[] digits) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        
        // Fix: Build the frequency map correctly
        for (int i = 0; i < digits.length; i++) {
            map.put(digits[i], map.getOrDefault(digits[i], 0) + 1);
        }

        for (int i = 100; i < 1000; i++) {
            if (i % 2 == 0) {
                String s = String.valueOf(i);
                int[] tempMap = new int[10];
                
                for (int d = 0; d < 10; d++) {
                    tempMap[d] = map.getOrDefault(d, 0);
                }

                boolean valid = true;
                for (int j = 0; j < 3; j++) {
                    int digit = s.charAt(j) - '0';
                    if (tempMap[digit] == 0) {
                        valid = false;
                        break;
                    } else {
                        tempMap[digit]--;
                    }
                }

                if (valid) {
                    res.add(i);
                }
            }
        }

        int[] result = new int[res.size()];
        int i = 0;
        for (int num : res) {
            result[i++] = num;
        }

        return result;
    }
}
