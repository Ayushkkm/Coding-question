class Solution {

    class pair implements Comparable <pair>{
        
        int val;
        int idx;
        
        public pair(int val , int idx){
            this.val = val;
            this.idx = idx;
        }
        
        public int compareTo(pair other){
            return Integer.compare(this.val , other.val);
        }
    }
    
    public int[] arrayRankTransform(int[] arr) {
        
        int N = arr.length;

        PriorityQueue<pair> minHeap = new PriorityQueue<>();

        int ans[] = new int[N];

        int rank = 1;

        for (int i = 0; i < N; i++) {

            minHeap.add(new pair(arr[i], i));
        }

        while (!minHeap.isEmpty()) {

            pair p = minHeap.remove();

            ans[p.idx] = rank;

            if (!minHeap.isEmpty() && p.val == minHeap.peek().val) { // if -> next element -> equal -> rank remain same

                continue;
            }

            rank++;

        }

        return ans;
    }
}

// TC -> O(NlogN)
// SC -> O(N)