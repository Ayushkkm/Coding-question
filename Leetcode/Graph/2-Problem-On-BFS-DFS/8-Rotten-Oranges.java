class Solution {
    class pair{
        int i ; 
        int j ; 
        int time ;

        pair(int i , int j , int time){
            this.i = i ;
            this.j = j ;
            this.time = time;
        }
    }
    public int orangesRotting(int[][] grid) {
        int cntfresh = 0;

        int n = grid.length;
        int m = grid[0].length ;

        int vis[][] = new int[n][m];

        Queue<pair> q = new LinkedList<>();
    
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j]==2){
                    q.add(new pair(i,j,0));
                    vis[i][j] = 2;
                }
                if(grid[i][j]==1){
                    cntfresh++;
                }
            }
        }

        int time = 0;
        int count = 0;

        int drow[] = {-1,0,1,0};
        int dcol[] = {0,1,0,-1};


        while(!q.isEmpty()){
            pair p = q.poll();
            int i = p.i;
            int j = p.j;
            int tm = p.time;

            time = Math.max(time,tm);

            for(int k = 0 ; k<4 ; k++){
                int row = i + drow[k];
                int col = j + dcol[k];

                if(row>=0 && row<n && col >= 0 && col <m && vis[row][col]!=2
                && grid[row][col]==1){
                    q.add(new pair(row,col , tm+1));
                    vis[row][col] = 2;
                    count++;
                }
            }
        }

        if(cntfresh!=count) return -1;

        return time;

    }
}