import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<List<Integer>> sol = new ArrayList<>();
    private List<Integer> initial = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(0, candidates, target);
        return sol;
    }

    private void backtrack(int index, int[] cand, int target) {
       
        if (target == 0) {
            sol.add(new ArrayList<>(initial));
            return;
        }

       
        if (index == cand.length || target < 0) {
            return;
        }

       
        initial.add(cand[index]);
        backtrack(index, cand, target - cand[index]);

        
        initial.remove(initial.size() - 1);
        
        backtrack(index + 1, cand, target);
    }
}
