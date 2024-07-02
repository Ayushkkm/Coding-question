class Solution {
    
    public String toString(int a , int b){
        
        return Integer.toString(a) + " " + Integer.toString(b);
    }
    
    public void dfs(int row , int col , int vis[][] , int grid[][],
    ArrayList<String> arr , int row0 , int col0){
        
        vis[row][col]=1;
        
        arr.add(toString(row-row0 , col - col0)); // any coordinate - base coordinate
        
        int n = grid.length;
        int m = grid[0].length;
        
        int drow[] = {-1, 0 , 1 , 0};
        int dcol[] = {0 , 1 , 0 , -1};
        
        for(int i = 0 ; i < 4 ; i++){
            
            int nrow = row + drow[i];
            int ncol = col + dcol[i];
            
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && 
            vis[nrow][ncol]==0 && grid[nrow][ncol]==1){
                dfs(nrow,ncol , vis , grid , arr , row0 , col0);
            }
        }
    }

    public int countDistinctIslands(int[][] grid) {

        // GFG
        
        int n = grid.length;
        int m = grid[0].length;
        
        int vis[][] = new int[n][m];
        
        Set<ArrayList<String>> set = new HashSet<>();
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(vis[i][j]==0 && grid[i][j]==1){
                    
                    ArrayList<String> arr = new ArrayList<>();
                    dfs(i, j , vis , grid , arr , i  , j);
                    
                    set.add(arr);
                }            
        }
        
    }
    
    return set.size();
 }
}
// TC -> N*M*4 
// SC -> O(N*M) -> vis[][] + set
