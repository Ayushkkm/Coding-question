class Solution {
    public List<List<Integer>> printGraph(int V, int edges[][]) {
       // GFG
        List<List<Integer>> list = new ArrayList<>();
        
        
        for(int i = 0 ; i < V ; i++){
            list.add(new ArrayList<Integer>());
        }
        
        for(int i = 0 ; i<edges.length ; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            
            list.get(u).add(v);
            list.get(v).add(u);
        }
        
        return list;
    }
}

 