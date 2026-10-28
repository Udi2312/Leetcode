
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char t : tasks) {
            freq[t - 'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int f : freq) {
            if (f > 0) pq.add(f);
        }
        int time = 0;
        while (!pq.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int cycle = 0;
            for (int i = 0; i < n+1 && !pq.isEmpty(); i++) {
                int f = pq.remove();
                cycle++;
                if (f - 1 > 0) {
                    temp.add(f - 1);
                }
            }
            pq.addAll(temp);
            if (pq.isEmpty()) {
                time += cycle;
            } else {
                time += n + 1;
            }
        }
        return time;
    }
}
