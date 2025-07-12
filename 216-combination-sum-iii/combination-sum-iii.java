class Solution {
    List<List<Integer>> sol = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(1, k, n, new ArrayList<>());
        return sol;
    }

    public void backtrack(int start, int k, int target, List<Integer> set) {
        if (k == 0 && target == 0) {
            sol.add(new ArrayList<>(set));
            return;
        }

        if (k == 0 || target < 0) {
            return;
        }

        for (int i = start; i <= 9; i++) {
            set.add(i);
            backtrack(i + 1, k - 1, target - i, set);
            set.remove(set.size() - 1);
        }
    }
}
