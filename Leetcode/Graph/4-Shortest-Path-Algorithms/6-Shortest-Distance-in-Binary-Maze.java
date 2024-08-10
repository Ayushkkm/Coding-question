class Solution {
    
    class tuple{
        
        int first;
        int second;
        int third;
        
        tuple(int first, int second, int third) {
        
        this.first = first; 
        this.second = second; 
        this.third = third; 
        
       } 
    }

    int shortestPath(int[][] grid, int[] source, int[] destination) {
        
        // GFG
         
        if(source[0] == destination[0] && // both are same
            source[1] == destination[1]){
                return 0;
            }
         
        Queue<tuple> q = new LinkedList<>();
        
        int n = grid.length; 
        int m = grid[0].length;
        
        int dist[][] = new int[n][m];
        
        for(int i = 0;i<n;i++) {
            
            for(int j =0;j<m;j++) {
                
                dist[i][j] = (int)(1e9); 
            }
        }
        
        dist[source[0]][source[1]] = 0; // source -> dist -> 0
        
        q.add(new tuple(0, source[0], source[1])); 
        
        int dr[] = {-1, 0, 1, 0}; 
        int dc[] = {0, 1, 0, -1}; // give -> direction
        
        while(!q.isEmpty()){
            
            tuple t = q.remove();
            
            int dis = t.first; 
            int r = t.second; 
            int c = t.third; 
            
            for(int i = 0 ; i < 4 ; i++){
                
                int nrow = r + dr[i];
                int ncol = c + dc[i];
                
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m 
                && grid[nrow][ncol] == 1 && dis + 1 < dist[nrow][ncol]) {
                   
                    dist[nrow][ncol] = 1 + dis; // weight is 1
                    
                    if(nrow == destination[0] &&  
                       ncol == destination[1]){ // if -> reach -> destination -> return dis+1
                           
                           return dis + 1;
                        }
                        
                    q.add(new tuple(dis+1 , nrow , ncol));
                }
             
            }
        }
    
    return -1; // destination -> not found
    
    }
}

// TC -> O(n*m)
// SC -> O(n*m)