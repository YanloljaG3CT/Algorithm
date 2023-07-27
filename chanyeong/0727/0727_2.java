public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(
                new int[][] {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}},
                new int[][] {{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}}
        ));
    }

    public int solution(int[][] board, int[][] skill) {
        int answer = 0;

        int y = board.length;
        int x = board[0].length;

        // 누적합
        int[][] prefixSum = new int[y][x];
        for (int[] round : skill) {
            int type = round[0];
            int degree = round[5];

            if (type == 1) {
                degree *= -1;
            }

            int y1 = round[1];
            int x1 = round[2];
            int y2 = round[3];
            int x2 = round[4];

            prefixSum[y1][x1] = degree;

            int vx = x2 + 1;
            if (vx < x) {
                prefixSum[y1][vx] = -1 * degree;
            }

            int vy = y2 + 1;
            if (vy < y) {
                prefixSum[vy][x1] = -1 * degree;
            }

            if (vx < x && vy < y) {
                prefixSum[vy][vx] = degree;
            }
        }

        // 행 누적합
        for (int i = 0; i < y; i++) {
            for (int j = 1; j < x; j++) {
                prefixSum[i][j] += prefixSum[i][j - 1];
            }
        }

        // 열 누적합
        for (int i = 0; i < x; i++) {
            for (int j = 1; j < y; j++) {
                prefixSum[j][i] += prefixSum[j - 1][i];
            }
        }

        // 결과
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (board[i][j] + prefixSum[i][j] > 0) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
