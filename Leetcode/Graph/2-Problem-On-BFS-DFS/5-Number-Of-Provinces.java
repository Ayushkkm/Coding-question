class Solution {

    public void dfs(Integer a , boolean vis[], ArrayList<ArrayList<Integer>> list ){
        vis[a]= true;

        for(Integer it : list.get(a)){
            if(vis[it]==false){
                dfs(it,vis,list);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        // Matrix -> ArrayList

       // 1-based indexing -> 
       // in matrix -> given 0th based index

       int v = isConnected.length;

       ArrayList<ArrayList<Integer>> list = new ArrayList<>();

       for(int i = 0 ; i<=v ; i++){
        list.add(new ArrayList<Integer>());
       }

       for(int i = 1 ; i <=v ; i++){
        for(int j= 1 ; j<=v ; j++){
            if(isConnected[i-1][j-1]==1 && i!=j){ // converted to real index
                list.get(i).add(j);
                list.get(j).add(i);
            }
        }
       }

       // Real -> count start
       
       int count = 0;
       boolean vis[] = new boolean[v+1];

       for(int i = 1 ; i<=v ; i++){
          if(vis[i]==false){
            count++;
            dfs(i,vis,list);
          }
       }

       return count;


    }
}

// TC -> O(V+E)
// SC -> O(3V) -> vis[] -> stack -> list

// GFG -> Number of Provinces

// Given ArrayList -> Values -> like matrix -> convert -> original ArrayList
 
class Solution {

    // Depth-First Search function
    static void dfs(Integer a , boolean vis[], ArrayList<ArrayList<Integer>> list ){
        vis[a]= true;

        for(Integer it : list.get(a)){
            if(vis[it]==false){
                dfs(it,vis,list);
            }
        }
    }
    

    // Function to find the number of provinces
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

       for(int i = 0 ; i<=V ; i++){
        list.add(new ArrayList<Integer>());
       }

       for(int i = 1 ; i <=V ; i++){
        for(int j= 1 ; j<=V ; j++){
            if(adj.get(i - 1).get(j - 1) == 1 && i!=j){ // converted to real index
                list.get(i).add(j);
                list.get(j).add(i);
            }
        }
       }

       // Real -> count start
       
       int count = 0;
       boolean vis[] = new boolean[V+1];

       for(int i = 1 ; i<=V; i++){
          if(vis[i]==false){
            count++;
            dfs(i,vis,list);
          }
       }

       return count;
    }
}