import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int T, N, M, K;
    static boolean[][] maps;

    public static void main(String[] args) {
        ScannerReader sr = new ScannerReader();
        T = sr.nextInt();

        for (int i = 0; i < T; i++) {
            input(sr);
            solution();
        }
    }

    private static void input(ScannerReader sr) {
        M = sr.nextInt();
        N = sr.nextInt();
        K = sr.nextInt();

        maps = new boolean[N][M];
        for (int i = 0; i < K; i++) {
            int x = sr.nextInt();
            int y = sr.nextInt();
            maps[y][x] = true;
        }
    }

    private static void solution() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (maps[i][j]) {
                    count++;
                    DFS(i, j);
                }
            }
        }
        System.out.println(count);
    }

    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};

    private static void DFS(int y, int x) {
        maps[y][x] = false;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny >= 0 && ny < maps.length && nx >= 0 && nx < maps[0].length && maps[ny][nx]) {
                DFS(ny, nx);
            }
        }
    }

    static class ScannerReader {

        private final BufferedReader br;
        private StringTokenizer st;

        public ScannerReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String readLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "";
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(readLine());
            }

            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
