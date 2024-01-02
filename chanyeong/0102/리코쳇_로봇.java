import java.util.*;

class Solution {

    static int height, width;
    static int[] goal, start;
    static boolean[][] visited;

    public int solution(String[] board) {
        height = board.length;
        width = board[0].length();
        visited = new boolean[height][width];
        init(board);
        return bfs(board);
    }

    private void init(String[] board) {
        for(int i=0; i<height; i++) {
            for (int j = 0; j < width; j++) {
                char ch = board[i].charAt(j);

                if (ch == 'R') {
                    start = new int[]{i, j};
                }

                if (ch == 'G') {
                    goal = new int[]{i, j};
                }

                if (!Objects.isNull(start) && !Objects.isNull(goal)) {
                    return;
                }
            }
        }
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    private int bfs(String[] board) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        visited[start[0]][start[1]] = true;
        int L = 0;

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                int[] cur = q.poll();
                if (Arrays.equals(goal, cur)) {
                    return L;
                }
                visited[cur[0]][cur[1]] = true;

                for (int j = 0; j < 4; j++) {
                    int ny = cur[0];
                    int nx = cur[1];

                    while (ny >= 0 && ny < height && nx >= 0 && nx < width
                            && board[ny].charAt(nx) != 'D') {
                        ny += dy[j];
                        nx += dx[j];
                    }

                    ny -= dy[j];
                    nx -= dx[j];

                    if (!visited[ny][nx]) {
                        q.offer(new int[]{ny, nx});
                    }
                }
            }
            L++;
        }
        return -1;
    }
}
