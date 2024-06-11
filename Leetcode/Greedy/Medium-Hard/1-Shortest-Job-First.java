class Solution {
    static int solve(int bt[] ) {
    
     // GFG
    int time = 0 ;
    int wtime = 0;
    
    Arrays.sort(bt);
    
    for(int i =0 ; i< bt.length ;i++){
        wtime += time;
        
        time += bt[i];
    }
    
    return wtime/bt.length;

  }
}
     