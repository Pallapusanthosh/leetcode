class Solution {
    Set<String> blockedset = new HashSet<>();
    int [][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    final int Limit = 200;
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        if(blocked.length == 0) return true;
        for(int[] block : blocked){
            blockedset.add(block[0] + "," + block[1]);
        }
        int maxarea = blocked.length * blocked.length;
        return bfs(source,target,maxarea) && bfs(target,source,maxarea);
    }
    public boolean bfs(int[] start , int[] end,int maxarea){
        Set<String> vis = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        vis.add(start[0] + "," + start[1]);

        int count = 0;
        while(!queue.isEmpty()){
            int [] curr = queue.poll();
            if(curr[0] == end[0] && curr[1] == end[1]) return true;
            if(++count > maxarea) return true;

            for(int [] dir : dirs){
                int nx = curr[0] + dir[0];
                int ny = curr[1] + dir[1];
                String pos = nx + "," + ny;
                if(nx >=0 && ny >=0 && nx < 1e6 && ny <1e6 && !blockedset.contains(pos) && !vis.contains(pos)){
                    queue.offer(new int[] {nx , ny});
                    vis.add(pos);
                }
            }
        }return false;
        
    }
}