class Solution {
    public int maxFrequencyElements(int[] nums) {
        int n = nums.length; 
        int max = nums[0];

        for(int i = 1 ; i < n; i++){
            if(nums[i] > max){
                max = nums[i];
            }
        }

        int hash[] = new int[max+1];

        for(int i = 0; i< n ; i++){
            hash[nums[i]]++;
        }

        max = hash[0];
        int count = 0;

        for(int i = 0 ; i < hash.length ; i++){
             if(hash[i] > max){
                max = hash[i];
             }
        }

        for(int i = 0; i < hash.length ; i++){
            if(max == hash[i]){
                count += max;
            }
        }

        return count;
    }
}

// 5.5% with this -> map.constainsKey() -> maxHeap.contains() -> both return boolean

// class pair implements Comparable<pair>{
    
//     int val;
//     int freq;
    
//     pair(int val , int freq){
      
//        this.val = val;
//        this.freq = freq;
//     }
    
//     public int compareTo(pair other){
//       return Integer.compare(other.freq , this.freq);
//     }
    
// }


// class Solution {
 
//     public int maxFrequencyElements(int[] nums) {
         
//         Map<Integer, Integer> map = new HashMap<>();
        
//         for(int num : nums){
//            map.put(num , map.getOrDefault(num , 0)+1);
//         }
        
//         PriorityQueue<pair> maxHeap = new PriorityQueue<>();
        
//         for(int key : map.keySet()){
//            maxHeap.offer(new pair(key , map.get(key)));
//         }
        
//         int ans = 0;
//         int max = 0;
        
//         while(!maxHeap.isEmpty()){
//             pair p = maxHeap.poll();
            
//             max = Math.max(max, p.freq);
            
//             if(max != p.freq) break;
            
//             ans += p.freq;
//         }
        
//         return ans ;
//     }
// }

// 66% with hash and priority Queue 

// class Solution {
 
//     public int maxFrequencyElements(int[] nums) {
         
//           int max = nums[0];
          
//           for(int num : nums){
//             max = Math.max(max , num);
//           }
          
//           int hash[] = new int[max+1];
          
//           for(int num : nums){
             
//               hash[num]++;
//           }
          
//           PriorityQueue<pair> maxHeap = new PriorityQueue<>();
          
//           for(int i = 0 ; i < max+1 ; i++){
              
//                if(hash[i] > 0){
//                   maxHeap.offer(new pair(i , hash[i]));
//                }
//           }
          
//           int maxV = 0;
//           int ans = 0;
          
//           while(!maxHeap.isEmpty()){
              
//               pair p = maxHeap.poll();
              
//               maxV = Math.max(maxV , p.freq);
              
//               if(maxV != p.freq) break;
              
//               ans += p.freq;
              
//           }
          
//           return ans ;
//    }
// }
