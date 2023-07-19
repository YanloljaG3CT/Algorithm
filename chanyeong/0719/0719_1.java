import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3})));
    }

    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];

        // 스테이지 현황
        int[] stagesSheet = new int[N + 2];
        for (int stage : stages) {
            stagesSheet[stage]++;
        }

        PriorityQueue<Stage> pQ = new PriorityQueue<>();

        // 실패율
        int person = stages.length;
        for (int i = 1; i < N + 1; i++) {
            double fail = 0;
            if (person != 0) {
                fail = (double) stagesSheet[i] / person;
            }

            pQ.offer(new Stage(i, fail));
            person -= stagesSheet[i];
        }

        for (int i = 0; i < N; i++) {
            answer[i] = pQ.poll().getNum();
        }

        return answer;
    }

    static class Stage implements Comparable<Stage> {
        private final int num;
        private final double fail;

        public int getNum() {
            return num;
        }

        public Stage(int num, double fail) {
            this.num = num;
            this.fail = fail;
        }

        @Override
        public int compareTo(Stage o) {
            if (fail == o.fail) return num - o.num;
            else if (fail < o.fail) return 1;
            return -1;
        }
    }
}
