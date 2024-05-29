class Solution
{
    long substrCount (String S, int K) {
       return atmost(S,K) - atmost(S,K-1); // Exactly K  
    }
    
    long atmost(String s , int k){
        
        int dist = 0;
        long ans = 0;
        int left = 0;
        
        int hash[] = new int[26];
        
        for(int i = 0 ; i< s.length() ; i++){
            hash[s.charAt(i)-'a']++; 
            
            if(hash[s.charAt(i)-'a']==1) dist++; // if 1 -> distinct -> if 2 not distint
            
            while(dist>k){
                hash[s.charAt(left)-'a']--;  // left -> initial 0 -> character remove
                
                if(hash[s.charAt(left)-'a']==0) dist--;       // count -> left = 0 -> not in substring
                left++; // left increase -> for next character
            }
            
            ans = ans+ i-left+1; // rigth - left +1 -> give substring -> (left,left+1, ..., i) -> atmost k
            
        }
        
        return ans;
    }
}

// Solution -> n^2 

// class Solution
// {
//     long substrCount (String S, int K) {
       
//       int n = S.length();
//       int ans = 0;
//       int dist_ans = 0;
       
//       int hash[] = new int[26];
       
       
//       for(int i = 0 ; i<n ; i++){
//           dist_ans = 0;
//           Arrays.fill(hash,0);
           
//           for(int j = i ; j<n ; j++){
               
//               if(hash[S.charAt(j)-'a']==0){
//                   dist_ans++;
//               }
//               hash[S.charAt(j)-'a']++;
               
//               if(dist_ans==K) ans++;
               
//           }
//       }
       
//       return ans ;
//     }
// }