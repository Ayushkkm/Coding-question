class pair implements Comparable<pair>{
    int start ;
    int end ;
    int position;
    
    pair(int start , int end , int position){
        this.start = start ;
        this.end = end;
        this.position = position;
    }
    
    public int compareTo(pair other){
        return Integer.compare(this.end,other.end);
    }
}

class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
       ArrayList<pair> arr = new ArrayList<pair>(); // we are storing -> to sort for end -> and take position of meeting
       
       for(int i = 0 ; i < n ; i++){
           arr.add(new pair(start[i],end[i],i+1)); // i+1 -> 1 based indexing
       }
       
       Collections.sort(arr); // Sort meetings based on end times
       
       int meetingNum = 1; // 1st meeting in arr -> we take 
       
       ArrayList<Integer> ansPos = new ArrayList<>();
       
       ansPos.add(arr.get(0).position); // add position of 1st 
       
       int limit = arr.get(0).end;
       
       for(int i = 1 ; i<arr.size();i++){
           if(arr.get(i).start>limit){
               limit = arr.get(i).end;
               ansPos.add(arr.get(i).position);
               meetingNum++;
               
           }
       }
       
       return meetingNum;
       
    }
}
// Expected Time Complexity: O(N*LogN)
// Expected Space: O(3N) + O(N)