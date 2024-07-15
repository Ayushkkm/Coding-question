// Intuition 1
// "travel to the last stone and then return to the first stone."
// It means there are two path from first to last stone,
// and two path have no intersection in the middle.
// We can image there are two frog jump from first to the last.


// Explanation
// So we are going to assign stones to two frogs alternatively:
// A[0] A[1] A[2] A[3] ...
// start frog1 frog2 frog1 ...

// If we assign them not alternatively like:
// frog1 frog2 frog2 frog1

// The distance for frog 1 is huge and it's no better than
// frog1 frog2 frog1 frog2

// So in this problem,
// we need to calculate the maximunm distance between A[i] - A[i-2].
// Special case is only two stones, so we initial res = A[1] - A[0].


class Solution {

     public int maxJump(int[] A) {
        int res = A[1] - A[0], n = A.length; // frog 1 -> jump 0 -> 1
       
        for(int i = 2; i < n; ++i) // it compute -> iterative -> frog1 -> frog2 -> frog1 -> frog2
            res = Math.max(res, A[i] - A[i - 2]);
        return res;
    }

}

// TC -> O(n)
// SC -> O(1)