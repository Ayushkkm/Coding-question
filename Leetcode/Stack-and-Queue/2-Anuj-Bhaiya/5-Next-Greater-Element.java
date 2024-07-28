
class solution{

    public ArrayList<Integer> NextGreater(int arr[]){

        Stack<Integer> st = new Stack<>();

        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = arr.length - 1 ; i >= 0 ; i--){

            while(!st.isEmpty() && st.peek() <= arr[i]){ // remove smallest -> element
                   
                   st.pop();
            }

            if(st.isEmpty() == true){ // stack become -> empty -> no previous greater element
                 ans.add(-1);
            }

            else{ // we got our -> previous greater element
              ans.add(st.peek());
            }

            st.push(arr[i]); // push -> current element
        }

        // Our -> ans -> list -> contains -> next Greater -> from last

        ArrayList<Integer> result = new ArrayList<>(); // Reverse the -> result list -> to maintain -> the original order
        
        for (int i = ans.size() - 1; i >= 0; i--) {
            result.add(ans.get(i));
        }

        return result;

    }
}

// TC -> O(N)
// SC -> O(N)