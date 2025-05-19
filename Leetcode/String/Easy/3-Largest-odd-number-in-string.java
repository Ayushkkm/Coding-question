class Solution {
    public String largestOddNumber(String num) {
        int n = num.length();
    
        for(int i = n-1 ; i>=0 ; i--){
            char c = num.charAt(i);
            if((c - '0')%2 != 0){
                return num.substring(0,i+1);
            }
        }

        return "";
    }
}


// Beat 5 % users ->  intuition is correct -> 2 for loop increase complexity

// class Solution {
//     public String largestOddNumber(String num) {
        
//         String ans = "";
//         int n = num.length();
//         int mark = -1;

//         for(int i = n-1 ; i >=0 ; i--){
//             char ch = num.charAt(i);

//             if(i==n-1 && ch%2!=0) return num ;
            
//             // if(ch%2!=0) ans += ch + "";

//             if(ch%2!=0){ // check from last -> first odd come -> mark it
//                mark = i;
//                break;
               
//                }
//         }

//         for(int  i = 0 ; i<=mark ;i++){
//             char ch = num.charAt(i);
//             ans+= ch + "";
//         }

//         return ans;

//     }
// }
