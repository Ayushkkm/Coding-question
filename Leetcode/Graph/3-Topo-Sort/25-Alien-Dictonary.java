class Solution
{
    
    public List<Integer> topological( ArrayList<ArrayList<Integer>> adj , int k){
        
        int indegree[] = new int[k];
        
        for(int i = 0 ; i < k ; i++){
            
            for(Integer a : adj.get(i)){
                indegree[a]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0 ;  i  < k ; i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        
        while(!q.isEmpty()){
            
            Integer node = q.poll();
            
            list.add(node);
            
            for(Integer a : adj.get(node)){
                indegree[a]--;
                
                if(indegree[a] == 0){
                    q.add(a);
                }
            }
        }
        
        return list;
    }
    
    
    public String findOrder(String [] dict, int N, int K)
    {

        // GFG
       
       ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
       
       for(int i = 0 ; i < K ; i++){
           
           adj.add(new ArrayList<>());
       }
       
       for(int i = 0 ; i < dict.length -1 ; i++){ // 0 -> n-2
           
           String s1 = dict[i];
           String s2 = dict[i+1];
           
           int len = Math.min(s1.length() , s2.length() ); // take min length
           
           for(int j = 0 ; j < len ; j++){ // fill adj
               
               if(s1.charAt(j) != s2.charAt(j)){ // s1 has -> edge to s2
                   
                   adj.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
                   break;
                   
               }
           }
       }
       
       List<Integer> topo = topological(adj , K);
       
       String ans = "";
       
       for(int i = 0 ; i < topo.size() ; i++){
           
           ans = ans + (char)(topo.get(i) + (int)'a');
       }
       
       return ans;
        
        
    }
}

// TC -> O(N + K)
// SC -> O(K + N)