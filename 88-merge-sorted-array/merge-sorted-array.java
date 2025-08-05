class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m + n];
        int j = 0;
        int i = 0;

        for (int k = 0; k < m + n; k++) {
            if (j == n || (i < m && nums1[i] < nums2[j])) {
                result[k] = nums1[i];
                i++;
               
            } else if (i == m || nums1[i] > nums2[j]) {
                result[k] = nums2[j];
                j++;
                
            } else {
                result[k] = nums1[i];
                i++;
                
            }
        }

        for (int k = 0; k < result.length; k++) {
            nums1[k] = result[k];
        }
    }
}
