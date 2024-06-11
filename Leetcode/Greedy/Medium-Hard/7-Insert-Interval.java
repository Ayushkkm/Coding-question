class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int []> arr = new ArrayList<>(); // create araaylist -> of array
        
       int i = 0 ;
       int n = intervals.length;

        while(i<n && intervals[i][1]<newInterval[0]){  // elements less than -> new intervals array -> put same
             arr.add(new int[]{intervals[i][0],intervals[i][1]});
             i++;
        }

        // merge portion

        while(i<n && intervals[i][0]<= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        arr.add(new int[]{newInterval[0],newInterval[1]}); // add that

        // Interval after newInterval -> put same

        while(i<n){
            arr.add(new int[]{intervals[i][0],intervals[i][1]});
            i++;
        }

        return arr.toArray(new int[0][]); // convert arraylist -> 2D matrix

    }
}
// TC -> N
// SC -> N -> Arraylist has -> n element -> it only structure it in 2D 