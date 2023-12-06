class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        int size = (n * n) + 1;
        int direct = 0;
        int row = 0;
        int col = -1;

        int i = 1;
        while(i < size) {
            int nr = row + dr[direct];
            int nc = col + dc[direct];

            if(nr < 0 || nr >= n || nc < 0 || nc >= n || answer[nr][nc] > 0) {
                direct = (direct + 1) % 4;
                continue;
            }

            answer[nr][nc] = i++;
            row = nr;
            col = nc;
        }

        return answer;
    }
}
