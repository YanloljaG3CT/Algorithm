
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//유기농 배추
public class bj1012 {
    static int n, m, k;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());

            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            map = new int[n][m];
            isVisited = new boolean[n][m];

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }

            int answer = 0;
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < m; l++) {
                    if (map[j][l] == 1 && !isVisited[j][l]) {
                        dfs(l, j);
                        answer++;
                    }
                }
            }
            System.out.println(answer);
        }
    }

    private static void dfs(int x, int y) {
        isVisited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < m && ny >= 0 && ny < n && map[ny][nx] == 1 && !isVisited[ny][nx]) {
                dfs(nx, ny);
            }
        }
    }

}
