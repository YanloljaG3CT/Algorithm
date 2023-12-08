class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int len = board.length;

        int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

        for (int r = 0; r < len; r++) {
            for (int c = 0; c < len; c++) {
                if (board[r][c] == 1) continue;

                boolean flag = true;
                for (int dir = 0; dir < 8; dir++) {
                    int nr = r + dr[dir];
                    int nc = c + dc[dir];

                    if (nr < 0 || nr >= len || nc < 0 || nc >= len) continue;

                    if (board[nr][nc] == 1) {
                        flag = false;
                        break;
                    }
                }

                if (flag) answer++;
            }
        }
        return answer;
    }
}