import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static char[][] arr;

    public static void main(String[] args) {
        input();
        solution();
    }

    private static void input() {
        ScannerReader sr = new ScannerReader();
        N = sr.nextInt();

        arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            String row = sr.readLine();
            arr[i] = row.toCharArray();
        }
    }

    static final StringBuilder sb = new StringBuilder();

    private static void solution() {
        recursive(0, 0, N);
        System.out.println(sb);
    }

    private static void recursive(int y, int x, int l) {
        if (isSameColor(y, x, l)) {
            sb.append(arr[y][x]);
            return;
        }

        sb.append("(");
        int len = l / 2;

        int[] dy = {0, 0, len, len};
        int[] dx = {0, len, 0, len};

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            recursive(ny, nx, len);
        }
        sb.append(")");
    }

    private static boolean isSameColor(int y, int x, int len) {
        char color = arr[y][x];

        for (int i = y; i < y + len; i++) {
            for (int j = x; j < x + len; j++) {
                if (arr[i][j] != color) {
                    return false;
                }
            }
        }

        return true;
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
