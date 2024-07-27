
class Solution{

    public ArrayList<Integer> previousSmall(int arr[]){

        Stack<Integer> st = new Stack<>();

        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = 0 ; i < arr.length ; i++){

            while(!st.isEmpty() && st.peek() >= arr[i]){ // remove greater -> element
                   
                   st.pop();
            }

            if(st.isEmpty() == true){ // stack become -> empty -> no previous smallest element
                 ans.add(-1);
            }

            else{ // we got our -> previous smallest element
              ans.add(st.peek());
            }

            st.push(arr[i]); // push -> current element
        }

        return ans;

    }
}

// TC -> O(N)
// SC -> O(N)
