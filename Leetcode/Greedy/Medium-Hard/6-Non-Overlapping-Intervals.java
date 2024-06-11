class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals , new Comparator<int []>(){
            public int compare(int a[] , int b[]){
                return Integer.compare(a[1],b[1]); 
            }
        }); // sort on column -> in ascending

        int count = 1; // maximum number of -> non overlapping interval
        int limit = intervals[0][1];

        for(int i = 1 ; i <n ; i++){
            if(intervals[i][0]>=limit){  // for intervls -> equal to also come
                count++;
                limit = intervals[i][1];
            }
        }

        return n - count; // Number of removed -> intervals

    }
}
// Expected Time Complexity: O(N*LogN)
// SC -> O(1) 