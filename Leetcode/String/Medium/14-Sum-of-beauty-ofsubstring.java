class Solution {

    public int beauty(int hash[]){
        int maxF = -1;
        int minF = Integer.MAX_VALUE; // if minF = 0 -> 1>0 -> not get change

        for(int i = 0 ; i<26 ; i++){
            maxF = Math.max(hash[i],maxF);

            if(hash[i]>=1){ // check if 0 value not fill
                minF = Math.min(minF,hash[i]);
            }
        }

        return maxF - minF;
    }
    public int beautySum(String s) {
        
        int n = s.length();
        int sum = 0;

        for(int i = 0 ; i<n ; i++){
            int hash[] = new int[26]; 
           
            for(int j = i ; j<n ;j++){ // ask chatgpt -> "aa" -> concept -> traverse -> single character
               
                hash[s.charAt(j)-'a']++; // fill of character -> and cheching of substring -> in single loop
                sum+= beauty(hash);
            }
        }

        return sum;
    }
}