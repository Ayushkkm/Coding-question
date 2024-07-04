class Solution {

    public boolean dfs(int node , int color , int V , int colour[] ,int[][] graph){

      colour[node] = color ;

       for(int a : graph[node]){
         if(colour[a]==-1){
            
            if(dfs(a , 1 - colour[node] , V , colour, graph)==false){
                return false;
            }
         }

         if(colour[a]==colour[node]){
            return false;
         }
       }

       return true;
        
    }

    public boolean isBipartite(int[][] graph) {

        // Can use -> adjacancy list
        // It is -> 0 based index -> i != j -> so use directly

        int V = graph.length;

        int colour[] = new int[V];

        Arrays.fill(colour,-1);

        for(int i = 0 ; i < V ; i++){

            if(colour[i]==-1){

              if(dfs(i , 0 , V , colour , graph)==false){
                return false;
              }
            }
        }

        return true;
    }
}

// TC -> O(V+E)
// SC -> O(V) -> colour[]


// class Solution {

//     public boolean dfs(int node , int V , int colour[] ,int[][] graph){

//       // colour[node] = 0; -> wrong -> make every recursive call -> colour == 0

//        for(int a : graph[node]){
//          if(colour[a]==-1){

//             colour[a] = 1 - colour[node];
//             if(dfs(a , V , colour, graph)==false){
//                 return false;
//             }
//          }

//          if(colour[a]==colour[node]){
//             return false;
//          }
//        }

//        return true;
        
//     }

//     public boolean isBipartite(int[][] graph) {

//         // Can use -> adjacancy list
//         // It is -> 0 based index -> i != j -> so use directly

//         int V = graph.length;

//         int colour[] = new int[V];

//         Arrays.fill(colour,-1);

//         for(int i = 0 ; i < V ; i++){

//             if(colour[i]==-1){
//               colour[i] = 0;
              
//               if(dfs(i , V , colour , graph)==false){
//                 return false;
//               }
//             }
//         }

//         return true;
//     }
// }