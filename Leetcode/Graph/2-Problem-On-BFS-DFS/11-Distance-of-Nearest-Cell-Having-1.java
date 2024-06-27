// Leetcode -> 0 

class Solution {
     
    class tuple{
        int row; 
        int col;
        int step;

        tuple(int row , int col, int step){
            this.row = row;
            this.col = col;
            this.step = step;
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int dist[][] = new int[n][m];
        int vis[][] = new int[n][m];

        Queue<tuple> q = new LinkedList<>();

        for(int i = 0 ; i <n ; i++){
            for(int j =0 ; j <m ; j++){
                if(mat[i][j]==0){
                   vis[i][j] = 1;
                   q.add(new tuple(i,j,0));
                }
            }
        }

        while(!q.isEmpty()){
            tuple t = q.poll();

            int i = t.row;
            int j = t.col;
            int stp = t.step;

            dist[i][j] = stp;

            int drow[] = {-1 ,0 , 1 , 0 };
            int dcol[] = {0 , 1 , 0 , -1};

            for(int k = 0  ; k <4 ; k++){
                int nrow = i + drow[k];
                int ncol = j + dcol[k];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && 
                vis[nrow][ncol]==0){
                 vis[nrow][ncol] = 1;
                 q.add(new tuple(nrow,ncol,stp+1));
                }
            }
        }

        return dist;
    }
}

// TC -> O(N*M*4) + O(N*M)
// SC -> O(N*M) -> vis[][]

// GFG -> 1

// class Solution
// {
//     class tuple{
//         int row; 
//         int col;
//         int step;

//         tuple(int row , int col, int step){
//             this.row = row;
//             this.col = col;
//             this.step = step;
//         }
//     }
    
//     public int[][] nearest(int[][] grid)
//     {
//         int n = grid.length;
//         int m = grid[0].length;

//         int dist[][] = new int[n][m];
//         int vis[][] = new int[n][m];

//         Queue<tuple> q = new LinkedList<>();

//         for(int i = 0 ; i <n ; i++){
//             for(int j =0 ; j <m ; j++){
//                 if(grid[i][j]==1){
//                    vis[i][j] = 1;
//                    q.add(new tuple(i,j,0));
//                 }
//             }
//         }

//         while(!q.isEmpty()){
//             tuple t = q.poll();

//             int i = t.row;
//             int j = t.col;
//             int stp = t.step;

//             dist[i][j] = stp;

//             int drow[] = {-1 ,0 , 1 , 0 };
//             int dcol[] = {0 , 1 , 0 , -1};

//             for(int k = 0  ; k <4 ; k++){
//                 int nrow = i + drow[k];
//                 int ncol = j + dcol[k];

//                 if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && 
//                 vis[nrow][ncol]==0){
//                  vis[nrow][ncol] = 1;
//                  q.add(new tuple(nrow,ncol,stp+1));
//                 }
//             }
//         }

//         return dist;
//     }
// }