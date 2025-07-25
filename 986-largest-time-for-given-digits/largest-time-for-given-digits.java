import java.util.*;

class Solution {
    public String largestTimeFromDigits(int[] arr) {
        List<List<Integer>> sol = new ArrayList<>();
        back(arr, 0, sol);
        //permutation--> base case i == a.length ayitey just add the arr to the sol 
        // if else start j loop from i and swap j and i backtrack and swap i and j and take the max time 
        int maxTime = -1;
        for (List<Integer> ar : sol) {
            int hh = ar.get(0) * 10 + ar.get(1);
            int mm = ar.get(2) * 10 + ar.get(3);
            if (hh < 24 && mm < 60) {
                int totalMinutes = hh * 60 + mm;
                maxTime = Math.max(maxTime, totalMinutes);
            }
        }

        if (maxTime == -1) return "";

        int max_hh = maxTime / 60;
        int max_mm = maxTime % 60;
        return String.format("%02d:%02d", max_hh, max_mm);
    }

    void back(int[] a, int i, List<List<Integer>> sol) {
        if (i == a.length) {
            List<Integer> cur = new ArrayList<>();
            for (int x : a) cur.add(x);
            sol.add(cur);
            return;
        }
        for (int j = i; j < a.length; j++) {
            swap(a, i, j);
            back(a, i + 1, sol);
            swap(a, i, j);
        }
    }

    void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
