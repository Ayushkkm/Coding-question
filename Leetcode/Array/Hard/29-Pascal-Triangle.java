class Solution {

    public List<Integer> row(int row){
        
        List<Integer> list = new ArrayList<>();

        int val = 1;

        list.add(val);

        for(int i = 1 ; i< row ; i++){
            
            val = val*(row-i);

            val = val/i ;

            list.add( (int)val );
        }

        return list;
    }

    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 1 ; i <= numRows ; i++){
           
           ans.add( row(i) );
        }


        return ans;

    }
}

// TC -> O(N^2)
// SC -> O(N^2)