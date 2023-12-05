import java.util.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int len = rank.length;
        PriorityQueue<Rank> pq = new PriorityQueue<>();
        for(int i=0; i<len; i++) {
            if(attendance[i]) {
                pq.offer(new Rank(i, rank[i]));
            }
        }

        return 10000 * pq.poll().num + 100 * pq.poll().num + pq.poll().num;
    }

    static class Rank implements Comparable<Rank> {
        int num;
        int rank;

        public Rank(int num, int rank) {
            this.num = num;
            this.rank = rank;
        }

        @Override
        public int compareTo(Rank o) {
            return rank - o.rank;
        }
    }
}
