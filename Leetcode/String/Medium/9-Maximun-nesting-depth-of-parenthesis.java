class Solution {
    public int maxDepth(String s) {
        int count = 0;
        int maxD = 0;

        for(char ch : s.toCharArray()){
            if(count<0) return maxD;

            if(ch=='('){
                count++;
                maxD = Math.max(maxD,count);
            } 
            else if(ch==')'){
                count--;
            }

        }
        return maxD;
    }
}