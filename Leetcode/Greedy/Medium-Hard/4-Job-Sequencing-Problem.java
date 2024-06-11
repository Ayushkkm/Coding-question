class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    { 
        // GFG
        
        Arrays.sort(arr, new Comparator<Job>(){
            public int compare (Job j1 , Job j2){
                // Sorting in descending order of profit
                return Integer.compare(j2.profit , j1.profit);
            }
        });  // sort array decending order of profit
        
        int maxdeadline = 0;
        
        for(int i = 0 ; i < arr.length ;i++){
            maxdeadline = Math.max(maxdeadline,arr[i].deadline);
        }
        
        int hash[] = new int[maxdeadline+1];
        
        Arrays.fill(hash , -1);
        
        int ans[] = new int[2];
        
        int profit = 0 ;
        int jobs = 0;
        
        for(int i = 0 ; i< arr.length ; i++){
             
             for(int  j = arr[i].deadline ; j >0 ; j--){ // To find empty dpace from last
                 if(hash[j]==-1){
                     hash[j] = arr[i].id;
                     profit += arr[i].profit;
                     jobs++;
                     
                     break;  // Break -> otherwise it fill -> more index 
                 }
                 
             }
        }
        
        ans[0] = jobs;
        ans[1] = profit;
        
        return ans;
        
        // TC -> N * Maxdeadline + NlogN
        
        
    }
}

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/