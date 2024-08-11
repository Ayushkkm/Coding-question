class Solution {

    class pair {
        int count;
        int node;

        pair(int count, int node) {
            this.count = count;
            this.node = node;
        }
    }

    public int minimumMultiplications(int[] arr, int start, int end) {
        
        if(start == end){
            return 0 ; // no multiplication -> need
        }

        Queue<pair> q = new LinkedList<>();
        
        int[] dist = new int[100000];
        
        for (int i = 0; i < 100000; i++){
            
            dist[i] = (int) (1e9);
        }

        dist[start] = 0;
        
        q.add(new pair(0, start));
        
        int mod = 100000;
        int n = arr.length;

        while (!q.isEmpty()) {

            pair p = q.remove();

            int steps = p.count;
            int node = p.node;

            for (int i = 0; i < n; i++) {

                int num = (arr[i] * node) % mod;
                
                if (steps + 1 < dist[num]) {
                    
                    dist[num] = steps + 1;
                    
                    if (num == end) {
                        return steps + 1;
                    }
                    
                    q.add(new pair(steps + 1, num));  
                }
            }
        }
        return -1;
    }
}

// TC -> O(10000*N)
// SC -> O(10000*N)
