class Solution {

    public void dfs(int i , int j ,int vis[][], 
    char[][] board , int drow[] , int dcol[]){

        int n = board.length;
        int m = board[0].length;

        vis[i][j] = 1;

        for(int k = 0 ; k < 4 ; k++){
           int nrow = i + drow[k];
           int ncol = j+ dcol[k];

           if(nrow>=0 && nrow <n && ncol >=0 && ncol<m 
           && vis[nrow][ncol]==0 && board[nrow][ncol]=='O'){
             dfs(nrow,ncol, vis, board , drow, dcol);
           }

        }
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        int vis[][] = new int[n][m];

        int drow[] = {-1,0,1, 0 };
        int dcol[] = {0,1 ,0 , -1};

        // Check row -> starting point

        for(int j = 0 ; j <m ; j++){
            
            // check 0th row

            if(vis[0][j]==0 && board[0][j] == 'O'){
                dfs(0,j,vis,board,drow,dcol);
            }

            // check last row 

            if(vis[n-1][j]==0 && board[n-1][j]=='O'){
                dfs(n-1,j,vis,board,drow,dcol);
            }
        }

        for(int i = 0 ; i < n ; i++){
            // check 0th col

            if(vis[i][0]==0 && board[i][0]=='O'){
                dfs(i,0,vis,board,drow,dcol);
            }

            // check last col

            if(vis[i][m-1]==0 && board[i][m-1]=='O'){
                dfs(i,m-1,vis,board,drow,dcol);
            }
        }
        
        // Convert O -> X

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(vis[i][j]==0 && board[i][j]=='O'){
                    board[i][j] = 'X';
                }
            }
        }


    }
}

// TC -> O(N*M*4)
// SC -> O(N*M) -> vis[][]
