import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] board;

    public static void main(String[] args) {
        input();
        solution();
    }

    private static void input() {
        ScannerReader sr = new ScannerReader();
        N = sr.nextInt();
        M = sr.nextInt();

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            char[] arr = sr.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                board[i][j] = arr[j] - '0';
            }
        }
    }

    private static void solution() {
        System.out.println(BFS());
    }

    private static int BFS() {
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        board[0][0] = 0;
        int L = 1;

        while (!q.isEmpty()) {
            L++;
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int[] cur = q.poll();
                for (int j = 0; j < 4; j++) {
                    int ny = cur[0] + dy[j];
                    int nx = cur[1] + dx[j];

                    if (ny == N - 1 && nx == M - 1) {
                        return L;
                    }
                    if (ny >= 0 && ny < N && nx >= 0 && nx < M && board[ny][nx] > 0) {
                        board[ny][nx] = 0;
                        q.offer(new int[]{ny, nx});
                    }
                }
            }
        }

        return -1;
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
