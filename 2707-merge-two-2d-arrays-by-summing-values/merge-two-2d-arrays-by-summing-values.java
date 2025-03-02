import java.util.*;

class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<ArrayList<Integer>> res = new ArrayList<>();
        int n1 = nums1.length, n2 = nums2.length;
        int i = 0, j = 0;

        while (i < n1 && j < n2) {
            if (nums1[i][0] == nums2[j][0]) {
                ArrayList<Integer> subl = new ArrayList<>();
                subl.add(nums1[i][0]);
                subl.add(nums1[i][1] + nums2[j][1]);
                res.add(subl);
                i++;
                j++;
            } else if (nums1[i][0] < nums2[j][0]) {
                ArrayList<Integer> subl = new ArrayList<>();
                subl.add(nums1[i][0]);
                subl.add(nums1[i][1]);
                res.add(subl);
                i++;
            } else {
                ArrayList<Integer> subl = new ArrayList<>();
                subl.add(nums2[j][0]);
                subl.add(nums2[j][1]);
                res.add(subl);
                j++;
            }
        }

        while (i < n1) {
            ArrayList<Integer> subl = new ArrayList<>();
            subl.add(nums1[i][0]);
            subl.add(nums1[i][1]);
            res.add(subl);
            i++;
        }

        while (j < n2) {
            ArrayList<Integer> subl = new ArrayList<>();
            subl.add(nums2[j][0]);
            subl.add(nums2[j][1]);
            res.add(subl);
            j++;
        }

        int[][] m = new int[res.size()][2];
        for (int k = 0; k < res.size(); k++) {
            m[k][0] = res.get(k).get(0);
            m[k][1] = res.get(k).get(1);
        }

        return m;
    }
}
