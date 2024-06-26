/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution {
    
    static class pair{
        Node node;
        int ver;
        
        pair(Node node , int ver){
            this.node = node ;
            this.ver = ver;
        }
    }
    
    static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        
        if(root==null) return list;
        
        Queue<pair> q = new LinkedList<>();
        
        Map<Integer , Integer> map = new TreeMap<>();
        
        q.add(new pair(root,0));
        
        while(!q.isEmpty()){
            pair p = q.poll();
            
            Node n = p.node;
            int v = p.ver;
            
            if(!map.containsKey(v)){
                map.put(v,n.data);
            }
            
            if(n.left!=null){
                q.add(new pair(n.left,v-1));
            }
            
            if(n.right != null){
                q.add(new pair(n.right,v+1));
            }
        }
        
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            list.add(entry.getValue());
        }
        
        return list;
        
    }
}
// TC -> O(N)
// SC -> O(N)