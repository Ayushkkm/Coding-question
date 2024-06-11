// import java.util.*;
// /*
// class Item {
//     int value, weight;
//     Item(int x, int y){
//         this.value = x;
//         this.weight = y;
//     }
// }
// */

class Solution {
    
    // GFG
    double fractionalKnapsack(int w, Item arr[], int n) {
        
        Arrays.sort(arr , new Comparator<Item>(){
            
            public int compare(Item a , Item b){
                
                double r1 = (double)a.value/a.weight; // don't put bracket -> (double)(a.value/a.weight); -> it calculate int -> then convert to doube -> it give wrong answer 
                double r2 = (double)b.value/b.weight;
                
                return Double.compare(r2,r1);  // it return 1 , -1 , 0 
            }
        });
        
      
        double totalVal = 0.0;
        
        for(int i = 0 ; i < n ; i++){
            
            if(w >= arr[i].weight ){
                totalVal += arr[i].value;
                w -= arr[i].weight ;
            }
            else{
                double val = (double)(arr[i].value)/arr[i].weight;
                
                totalVal += val * w ;
                
                break;
            }
        }
        
        return totalVal;
        
    }
}
// Expected Time Complexity: O(NlogN)
// Expected Space Complexity: O(1)