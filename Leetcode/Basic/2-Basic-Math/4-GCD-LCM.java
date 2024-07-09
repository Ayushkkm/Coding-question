class Solution {
    static Long[] lcmAndGcd(Long A , Long B) {
        
        Long ans[] = new Long[2];
        
        Long n1 = A;
        Long n2 = B;
        
        while(n1 % n2 !=0){
            Long rem = n1 % n2 ;
            
            n1 = n2;
            n2 = rem;
        }
        
        ans[1] = n2;
        
        ans[0] = (A*B)/n2;
        
        return ans;
    }
};

