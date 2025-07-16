class Solution {
    public List<List<String>> solveNQueens(int n) {
        
        List<List<String>> sol = new ArrayList<>();
        int [] bottomleft = new int[(2 * n) -1];
        int [] topleft = new int[(2*n)-1];
        int [] rowhash = new int[n];
        solve(0,new ArrayList<>(),sol,n,rowhash,bottomleft,topleft);
        return sol;
    }
   
    public void solve(int col,List<String> board , List<List<String>> sol , int n,
        int [] rowhash  , int [] bottomleft,int [] topleft  ){
        if(col == n){
            sol.add(new ArrayList<>(board));
          
            return;
        }
        
        for(int row = 0; row <n;row++){
            if(bottomleft[col + row]==0 && topleft[n-1 +col-row] ==0 && rowhash[row]==0 ){
                 String s = ".".repeat(n);
                   board.add(putchar(s,row,'Q'));
                  
                  bottomleft[col+row] = 1;
                   topleft[n-1 +col-row] =1;
                   rowhash[row]=1;
                   solve(col + 1,board,sol,n,rowhash,bottomleft,topleft);

                   //backtrack
                   board.remove(board.size() -1);
                   bottomleft[col+row] = 0;
                   topleft[n-1 + col-row] =0;
                   rowhash[row]=0;

            }
        }
    }
     public  String putchar(String s, int i, char c) {
    char[] a = s.toCharArray();
    a[i] = c;
    return new String(a);
}

}