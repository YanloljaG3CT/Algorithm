class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1,0};
        int[] dc = {0, 1, 1, 1, 0, -1, -1, -1,0};
        int n = board.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = true;
                for (int k = 0; k < dr.length; k++) {
                    int r = i + dr[k];
                    int c = j + dc[k];
                    if (r < 0 || c < 0 || r >= board.length || c >= board.length) {
                        continue;
                    }
                    if (board[r][c] == 1) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
