class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> sol = new ArrayList<>();
        for (int i = 0; i < folder.length; i++) {
            if (sol.isEmpty() || check(sol.get(sol.size() - 1), folder[i])) sol.add(folder[i]);
        }
        return sol;
    }
    public boolean check(String s, String s1) {
        return !s1.startsWith(s + "/");
    }
}
