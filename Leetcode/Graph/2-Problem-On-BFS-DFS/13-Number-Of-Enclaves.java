class Solution {

    class pair{
        int row;
        int col ;

        pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int vis[][] = new int[n][m];

        Queue<pair> q = new LinkedList<>();

        for(int i = 0 ; i< n ; i++){
            for(int j = 0 ; j<m; j++){
                
                // Row at 0th , n-1 index -> column at 0th , m-1 index

                if(i==0|| i==n-1 || j==0 || j==m-1){
                    if(grid[i][j]==1){
                         vis[i][j] = 1;
                         q.add(new pair(i,j));
                    }
                }
            }
        }

        int drow[] = {-1,0,1,0};
        int dcol[] = {0,1,0,-1};

        while(!q.isEmpty()){
            pair p = q.poll();
            int i = p.row;
            int j = p.col;

            for(int k = 0; k<4 ; k++){
                int nrow = i + drow[k];
                int ncol = j + dcol[k];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 &&
                grid[nrow][ncol]==1){
                    vis[nrow][ncol] =1;
                    q.add(new pair(nrow,ncol));
                }

            }   

        }
        
        int count=0;

        for(int r = 0 ; r < n ; r++){
            for(int c  = 0 ; c <m ; c++){
                if(grid[r][c]==1 && vis[r][c]==0){
                    count++;
                }
            }
        }

        return count;
    }
}

// TC -> O(N*M*4)
// SC -> O(N*M) -> vis[][]
