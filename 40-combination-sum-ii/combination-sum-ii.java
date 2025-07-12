import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private List<List<Integer>> sol = new ArrayList<>();
    private List<Integer> initial = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(0, candidates, target);
        return sol;
    }

    private void backtrack(int index, int[] cand, int target) {
        if (target == 0) {
            sol.add(new ArrayList<>(initial));
            return;
        }

        for (int i = index; i < cand.length; i++) {
            if (i > index && cand[i] == cand[i - 1]) continue; // Skip duplicates
            if (cand[i] > target) break;

            initial.add(cand[i]);
            backtrack(i + 1, cand, target - cand[i]);
            initial.remove(initial.size() - 1);
        }
    }
}
