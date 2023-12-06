class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        //시작 위치
        int r = 0, c = 0;
        //시작 방향
        int d = 1;
        int num = 1;

        while (num <= n * n) {
            answer[r][c] = num;
            num++;

            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nc < 0 || nr >= n || nc >= n || answer[nr][nc] != 0) {
                // 방향을 변경
                d = (d + 1) % 4;
                nr = r + dr[d];
                nc = c + dc[d];
            }

            r = nr;
            c = nc;
        }
        return answer;
    }
}
