
class Solution{

    public ArrayList<Integer> NextSmaller(int arr[]){

        Stack<Integer> st = new Stack<>();

        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = arr.length -1 ; i >= 0 ; i--){

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

        // Our -> ans -> list -> contains -> next smaller -> from last

        ArrayList<Integer> result = new ArrayList<>(); // Reverse the -> result list -> to maintain -> the original order
        
        for (int i = ans.size() - 1; i >= 0; i--) {
            result.add(ans.get(i));
        }

        return result;

    }
}

// TC -> O(N)
// SC -> O(N)
