import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        PriorityQueue<Intercept> pq = new PriorityQueue<>();
        for(int[] target : targets) {
            pq.offer(new Intercept(target[0], target[1]));
        }

        int end = Integer.MIN_VALUE;
        while(!pq.isEmpty()) {
            Intercept cur = pq.poll();
            if(cur.start > end) {
                end = cur.end - 1;
                answer++;
            }
        }
        return answer;
    }

    static class Intercept implements Comparable<Intercept> {

        int start;
        int end;

        public Intercept(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Intercept o) {
            if(end == o.end) {
                return start - o.start;
            }
            return end - o.end;
        }
    }
}
