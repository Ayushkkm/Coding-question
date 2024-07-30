class Solution {
    public int leastInterval(char[] tasks, int n) {

        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : tasks) { // frequency -> store
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (Character key : map.keySet()) { // for -> get -> higher frequency -> element
            pq.add(map.get(key));
        }

        int countInterval = 0;

        while (!pq.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<>(); // to store -> n+1 -> element

            for (int i = 1; i <= n + 1; i++) { // take -> n+1 -> higher frequency -> element
                if (!pq.isEmpty()) {
                    int freq = pq.peek();
                    pq.poll();
                    freq--;
                    temp.add(freq);
                }
            }

            for (int val : temp) { // put -> with reduce -> freuency
                if (val > 0) {
                    pq.add(val);
                }
            }

            if (!pq.isEmpty()) { // if -> pq not empty -> full n+1 block -> take
                countInterval += n + 1;
            }

            else { // pq is -> empty -> take size of -> temp

                countInterval += temp.size();
            }
        }

        return countInterval;
    }
}

// TC -> O(Nlog26) // Capital Alphabet -> only
// SC -> O(N)