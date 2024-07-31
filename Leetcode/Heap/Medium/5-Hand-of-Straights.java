class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        
        int n = hand.length;

        if(n % groupSize !=0){ // if -> not -> we can not -> arrange -> in group
            return false;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int a : hand){ // add all -> element -> in minHeap
            minHeap.add(a);
        }

        while(!minHeap.isEmpty()){
            int val = minHeap.remove();

            for(int i = 1 ; i <groupSize ; i++){
                
                if(minHeap.remove(val+i)){ // check -> consequtive -> present -> or not
                    continue;
                }
                else{
                    return false;
                }
            }
        }

        return true;
       
    }
}

// TC -> O(NlogN)
// SC -> O(N)