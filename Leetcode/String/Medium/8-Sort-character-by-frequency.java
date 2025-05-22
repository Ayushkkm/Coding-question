class Solution {

    class Pair implements Comparable<Pair> {
        char ch;
        int count;

        Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }

        public int compareTo(Pair other) {
            // Max-Heap: sort in decreasing order of count
            return Integer.compare(other.count, this.count);
        }
    }

    public String frequencySort(String s) {
        
        // small(97-122) , capital(65-90) , digits(48-57)
        
        int[] hash = new int[125];
        
        // toCharArray -> convert to char array -> each element -> find

        for (char ch : s.toCharArray()) {
            hash[ch]++;
        }

        // Max-heap using natural ordering defined in Pair
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>();

        for (int i = 48; i < 125; i++) {
            if (hash[i] > 0) {
                maxHeap.offer(new Pair((char) i, hash[i]));
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            Pair p = maxHeap.poll();
            for (int i = 0; i < p.count; i++) {
                sb.append(p.ch);
            }
        }

        return sb.toString();
    }
}
