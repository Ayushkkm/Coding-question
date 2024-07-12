
// Problem -> Better String

class Solution {
    
    public static void subsequence(int i , int n , String str ,
    String s , Set<String> set ){
        
        if(i==n){
            set.add(s);
            
            return;
        }
        
        // Take
        
        subsequence(i+1 , n , str , s + str.charAt(i) , set);
        
        // Not take
    
        subsequence(i+1 , n , str , s , set);
    }
    
    
    public static String betterString(String str1, String str2) {
        
        // Find -> all subsequences -> store in set
        
        Set<String> set1 = new HashSet<>();
        
        Set<String> set2 = new HashSet<>();
        
        String s = "";
        
        subsequence( 0 , str1.length() , str1 , s , set1);
        
        subsequence( 0 , str2.length() , str2 , s , set2);
        
        if(set1.size() >= set2.size()){
            
            return str1;
        }
        
        return str2;
        

    }
}


// TC -> O(2^N)
// SC -> O(N)

// This code is no optimisez -> use DP
