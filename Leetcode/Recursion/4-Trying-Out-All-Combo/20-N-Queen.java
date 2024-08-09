class Solution {

    public List<String> construct(char[][] board) {

        List<String> res = new LinkedList<String>();

        for (int i = 0; i < board.length; i++) {

            String s = new String(board[i]); // make string of -> full board
            res.add(s);
        }

        return res;
    }

    public void solve(int col, char[][] board, List<List<String>> res, int leftRow[], int lowerDiagonal[],
            int upperDiagonal[]) {

        if (col == board.length) {
            res.add(construct(board)); // construct -> add
            return;
        }

        for (int row = 0; row < board.length; row++) { // in col -> check -> every row

            if (leftRow[row] == 0 && lowerDiagonal[row + col] == 0
                    && upperDiagonal[board.length - 1 + col - row] == 0) {

                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[board.length - 1 + col - row] = 1;

                solve(col + 1, board, res, leftRow, lowerDiagonal, upperDiagonal);

                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[board.length - 1 + col - row] = 0;
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {

        char[][] board = new char[n][n];
        
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';

        List<List<String>> res = new ArrayList<List<String>>();
       
        int leftRow[] = new int[n];
        int upperDiagonal[] = new int[2 * n - 1];
        int lowerDiagonal[] = new int[2 * n - 1];
        
        solve(0, board, res, leftRow, lowerDiagonal, upperDiagonal);
        return res;
    }
}

// TC -> O(n! * n) -> n -> loop
// SC -> O(n) + O(n) + O(n) + O(n) -> recursion stack + leftRow + upperDiagonal + lowerDiagonal