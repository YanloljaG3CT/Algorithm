import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        input();
        solution();
    }

    static int N;
    static char[][] board;

    private static void input() {
        ScannerReader sr = new ScannerReader();
        N = sr.nextInt();

        board = new char[N][N];
        for (int i = 0; i < N; i++) {
            String str = sr.readLine();

            for (int j = 0; j < N; j++) {
                board[i][j] = str.charAt(j);
            }
        }
    }

    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {1, 0, -1, 0};

    private static void solution() {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 4; k++) {
                    int ny = i + dy[k];
                    int nx = j + dx[k];

                    if (ny >= 0 && ny < N && nx >= 0 && nx < N) {
                        change(i, j, ny, nx);

                        max = Math.max(max, candyCount(i, j, board[i][j]));
                        if (max == N) {
                            System.out.println(N);
                            return;
                        }

                        change(ny, nx, i, j);
                    }
                }
            }
        }

        System.out.println(max);
    }

    private static void change(int y, int x, int ny, int nx) {
        char tmp = board[y][x];
        board[y][x] = board[ny][nx];
        board[ny][nx] = tmp;
    }

    private static int candyCount(int y, int x, char color) {
        // 행
        int xCount = 1;

        int nx = x + 1;
        while (nx < N) {
            if (board[y][nx] != color) {
                break;
            }
            xCount++;
            nx++;
        }

        nx = x - 1;
        while (nx >= 0) {
            if (board[y][nx] != color) {
                break;
            }
            xCount++;
            nx--;
        }

        // 열
        int yCount = 1;

        int ny = y + 1;
        while (ny < N) {
            if (board[ny][x] != color) {
                break;
            }
            yCount++;
            ny++;
        }

        ny = y - 1;
        while (ny >= 0) {
            if (board[ny][x] != color) {
                break;
            }
            yCount++;
            ny--;
        }

        return Math.max(yCount, xCount);
    }

    static class ScannerReader {

        private final BufferedReader br;
        private StringTokenizer st;

        public ScannerReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String readLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }

            return str;
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
