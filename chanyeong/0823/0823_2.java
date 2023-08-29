import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        input();
        solution();
    }

    static int N;
    static int[][] board;

    private static void input() {
        ScannerReader sr = new ScannerReader();
        N = 19;

        board = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                board[i][j] = sr.nextInt();
            }
        }
    }

    public static void solution() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (board[i][j] != 0) {
                    int result = count(i, j, board[i][j]);

                    if (result != 0) {
                        System.out.println(result);
                        System.out.println(i + " " + j);
                        return;
                    }
                }
            }
        }

        System.out.println(0);
    }

    static int[] dy = {-1, 0, 1, 1};
    static int[] dx = {1, 1, 1, 0};

    private static int count(int y, int x, int doll) {
        int[] count = {1, 1, 1, 1};

        for (int i = 0; i < count.length; i++) {
            int ny = y;
            int nx = x;
            while (true) {
                ny += dy[i];
                nx += dx[i];

                if (ny > N || nx > N || board[ny][nx] != doll) {
                    break;
                }

                count[i]++;
            }

            if (count[i] == 5) {
                int py = y - dy[i];
                int px = x - dx[i];
                if (py > 0 && px > 0
                        && doll == board[py][px]) {
                    count[i]++;
                }
            }
        }

        return Arrays.stream(count).anyMatch(n -> n == 5) ? doll : 0;
    }

    static private class ScannerReader {

        private final BufferedReader br;
        private StringTokenizer st;

        public ScannerReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String readLine() {
            String str = "";

            try {
                str = br.readLine();
            } catch (IOException e) {
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
