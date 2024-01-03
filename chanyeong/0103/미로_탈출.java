import java.util.*;

class Solution {

    static int height, width;
    static int[] start, lever;
    static boolean[][] visited;

    public int solution(String[] maps) {
        height = maps.length;
        width = maps[0].length();
        init(maps);

        int leverCount = bfs(maps, start, 'L');
        if (leverCount < 0) {
            return -1;
        }

        int endCount = bfs(maps, lever, 'E');
        if (endCount < 0) {
            return -1;
        }

        return leverCount + endCount;
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    private int bfs(String[] maps, int[] start, char goal) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);

        visited = new boolean[height][width];
        visited[start[0]][start[1]] = true;
        int L = 0;

        while (!q.isEmpty()) {
            L++;
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int[] cur = q.poll();

                for (int j = 0; j < 4; j++) {
                    int ny = cur[0] + dy[j];
                    int nx = cur[1] + dx[j];

                    if (ny >= 0 && ny < height && nx >= 0 && nx < width
                            && !visited[ny][nx] && maps[ny].charAt(nx) != 'X'
                    ) {
                        if (maps[ny].charAt(nx) == goal) {
                            return L;
                        }

                        q.offer(new int[]{ny, nx});
                        visited[ny][nx] = true;
                    }
                }
            }
        }
        return -1;
    }

    private void init(String[] maps) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                char ch = maps[i].charAt(j);

                if (ch == 'S') {
                    start = new int[]{i, j};
                }

                if (ch == 'L') {
                    lever = new int[]{i, j};
                }

                if (!Objects.isNull(start) && !Objects.isNull(lever)) {
                    return;
                }
            }
        }
    }
}
