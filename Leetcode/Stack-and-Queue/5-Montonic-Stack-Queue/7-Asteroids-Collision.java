class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < asteroids.length ; i++){

            if(asteroids[i] > 0){ // move right -> put in stack
               
               st.push(asteroids[i]);
            }
            else{ // negative
               
                while(!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(asteroids[i])){ // remove -> all lesser -> +ve
                        st.pop();
                }

                if(!st.isEmpty() && st.peek() == Math.abs(asteroids[i])){ // if equal -> remove -> both positive -> and negative -> negative remove -> by i increment
                       st.pop();
                }
                else if(st.isEmpty() || st.peek() < 0){ // empty stack -> or inside also -> negative -> add asteroids[i] -> no collision happens
                      st.push(asteroids[i]);
                }
            }
        }

        int ans[] = new int[st.size()];

        for(int i = st.size()-1 ; i >= 0 ; i--){
            ans[i] = st.pop();
        }

        return ans;
    }
}

// TC -> O(2n)
// SC -> O(n)