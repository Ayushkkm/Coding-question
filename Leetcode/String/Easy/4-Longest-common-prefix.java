class Solution {

    public String common(String s1 , String s2){
        int n = Math.min(s1.length(), s2.length());
        StringBuilder str = new StringBuilder();

        for(int i = 0 ; i<n ; i++){
            if(s1.charAt(i)==s2.charAt(i)){
                str.append(s2.charAt(i));
            }
            else{
                break;
            }
        }
        return str.toString();
        
    }
    
    public String longestCommonPrefix(String[] strs) {
        String res = strs[0];

        for(int i = 1 ; i < strs.length ; i++){
            res = common(res , strs[i]);
        }

        return res;
    }
}