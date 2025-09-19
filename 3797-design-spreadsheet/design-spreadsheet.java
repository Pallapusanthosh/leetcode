class Spreadsheet {
    public int[][] sheet;
    public Spreadsheet(int rows) {
        sheet = new int[rows + 1][27];
    }
    
    public void setCell(String cell, int value) {
        int col = cell.charAt(0) - 'A' + 1;
        int row = Integer.parseInt(cell.substring(1,cell.length()));
         
        
        sheet[row][col] = value;
    }
    
    public void resetCell(String cell) {
        
        int col = (cell.charAt(0) - 'A' )  + 1;
        int row = Integer.parseInt(cell.substring(1,cell.length()));
        sheet[row][col] = 0;
    }
    
    public int getValue(String formula) {
        String s = formula.substring(1,formula.length());
        String[] ops = s.split("\\+");
         return parseop(ops[0]) + parseop(ops[1]);
    
        
    }
    private int parseop(String op){
        try{
            return Integer.parseInt(op);
        }catch(Exception e){
            int col = op.charAt(0) - 'A' + 1;
            int row = Integer.parseInt(op.substring(1));
            
            return sheet[row][col];
        }
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */