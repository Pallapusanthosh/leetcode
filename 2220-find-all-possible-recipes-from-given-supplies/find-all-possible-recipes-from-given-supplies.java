import java.util.*;

class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> inDegree = new HashMap<>();
        List<String> result = new ArrayList<>();

        // Initialize graph and in-degree
        for (int i = 0; i < recipes.length; i++) {
            inDegree.put(recipes[i], ingredients.get(i).size());
            for (String ingredient : ingredients.get(i)) {
                graph.computeIfAbsent(ingredient, k -> new ArrayList<>()).add(recipes[i]);
            }
        }

        // Add initial supplies to the queue
        Queue<String> queue = new LinkedList<>();
        for (String supply : supplies) {
            queue.add(supply);
        }

        // Process the queue
        while (!queue.isEmpty()) {
            String current = queue.poll();

            if (!graph.containsKey(current)) continue;

            for (String recipe : graph.get(current)) {
                inDegree.put(recipe, inDegree.get(recipe) - 1);
                if (inDegree.get(recipe) == 0) {
                    queue.add(recipe);
                    result.add(recipe);
                }
            }
        }

        return result;
    }
}
