class Solution {
    public String alphabetBoardPath(String target) {
        StringBuilder result = new StringBuilder();
        int curRow = 0, curCol = 0;

        for (char ch : target.toCharArray()) {
            int index = ch - 'a';
            int targetRow = index / 5;
            int targetCol = index % 5;

            // Special handling for 'z' (only in last row, first col)
            // Go UP and LEFT first to avoid invalid positions
            if (ch == 'z') {
                // First move left, then down
                while (curCol > targetCol) {
                    result.append('L');
                    curCol--;
                }
                while (curRow < targetRow) {
                    result.append('D');
                    curRow++;
                }
            } else {
                // Move up/down first
                while (curRow > targetRow) {
                    result.append('U');
                    curRow--;
                }
                while (curRow < targetRow) {
                    result.append('D');
                    curRow++;
                }
                // Then move left/right
                while (curCol > targetCol) {
                    result.append('L');
                    curCol--;
                }
                while (curCol < targetCol) {
                    result.append('R');
                    curCol++;
                }
            }

            result.append('!');
        }

        return result.toString();
    }
}
