class Spreadsheet {
    // public int[][] sheet;
    //instead of int[][] we can use hashmap for <String , Integer>
    public HashMap<String , Integer> sheet;
    public Spreadsheet(int rows) {
        sheet = new HashMap<>();
    }
    
    public void setCell(String cell, int value) {
        sheet.put(cell,value);
    }
    
    public void resetCell(String cell) {
        
       sheet.remove(cell);
    }
    
    public int getValue(String formula) {
        int index = formula.indexOf('+');
        String leftstr = formula.substring(1,index);
        String rightstr = formula.substring(index + 1);
        int x = Character.isLetter(leftstr.charAt(0))  ? sheet.getOrDefault(leftstr,0) : Integer.parseInt(leftstr);
        int y = Character.isLetter(rightstr.charAt(0))  ? sheet.getOrDefault(rightstr,0) : Integer.parseInt(rightstr);
        return x + y;
        
    }
  
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */