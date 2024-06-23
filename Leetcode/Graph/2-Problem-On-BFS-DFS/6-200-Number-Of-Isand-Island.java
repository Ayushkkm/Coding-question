class Solution {

    class pair{
        int i;
        int j;

        pair(int i , int j){
            this.i = i;
            this.j = j;
        }
    }

    public void bfs(int i , int j , int vis[][] , char grid[][]){
        vis[i][j] = 1;
        Queue<pair> q = new LinkedList<>();

        int n = grid.length;
        int m = grid[0].length;

        q.add(new pair(i,j));

        while(!q.isEmpty()){
            pair p = q.poll();

            int row = p.i;
            int col = p.j; 

            // neighbour -> 8 direction -> horizontal -> vertical -> diagonal

            for(int dr = -1 ; dr<=1 ; dr++){
                for(int dc = -1 ; dc<=1 ; dc++){
                    int nrow = row + dr;
                    int ncol = col + dc;

                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 
                    && grid[nrow][ncol]=='1'){
                        vis[nrow][ncol] = 1;
                        q.add(new pair(nrow,ncol));
                    }
                }
            }
        }

    }


    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int vis[][] = new int[n][m];
        int island = 0;

        for(int i = 0 ; i< n ; i++){
            for(int j = 0 ; j <m ; j++){
                if(vis[i][j]==0 && grid[i][j]=='1'){
                    bfs(i,j , vis, grid);
                    island++;
                }
            }
        }

        return island;

    }

    
}

// TC -> O(N*M)
// SC -> O(N*M) -> vis[][] -> queue

// In leetcode -> 4 direction given -> horizontal -> vertical 

class Solution {

    class pair{
        int i;
        int j;

        pair(int i , int j){
            this.i = i;
            this.j = j;
        }
    }

    public void bfs(int i , int j , int vis[][] , char grid[][]){
        vis[i][j] = 1;
        Queue<pair> q = new LinkedList<>();

        int n = grid.length;
        int m = grid[0].length;

        q.add(new pair(i,j));

         // Directions array for 4 directions (up, down, left, right)
        int[] rowDir = {-1, 1, 0, 0};
        int[] colDir = {0, 0, -1, 1};

        while(!q.isEmpty()){
            pair p = q.poll();

            int row = p.i;
            int col = p.j; 

            // Check all 4 possible directions
            for (int k = 0; k < 4; k++) {
                int nrow = row + rowDir[k];
                int ncol = col + colDir[k];

                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 
                    && grid[nrow][ncol]=='1'){
                        vis[nrow][ncol] = 1;
                        q.add(new pair(nrow,ncol));
                    }
                }
            }
        }

    
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int vis[][] = new int[n][m];
        int island = 0;

        for(int i = 0 ; i< n ; i++){
            for(int j = 0 ; j <m ; j++){
                if(vis[i][j]==0 && grid[i][j]=='1'){
                    bfs(i,j , vis, grid);
                    island++;
                }
            }
        }

        return island;

    }

}
