class Solution
{
    public static void dfs(int node , int vis[] , Stack<Integer> st ,
    ArrayList<ArrayList<Integer>> adj){
        
        vis[node] = 1;
        
        for(Integer a : adj.get(node)){
            if(vis[a] == 0){
                dfs(a , vis, st , adj);
            }
        }
        
        st.push(node);
    }
    
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        int vis[]  = new int[V];
        
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0 ; i < V ; i++){
            if(vis[i]==0){
                dfs(i , vis , st , adj);
            }
        }
        
        int ans[] = new int[V];
        int i = 0 ;
        
        while(!st.isEmpty()){
            ans[i++] = st.pop();
        }
        
        return ans;
    }
}
// TC -> O(V+E)
// SC -> O(V) -> stack
