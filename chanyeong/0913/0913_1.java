import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, r, c;

    public static void main(String[] args) {
        input();
        solution();
    }

    private static void input() {
        ScannerReader sr = new ScannerReader();
        N = sr.nextInt();
        r = sr.nextInt();
        c = sr.nextInt();
    }

    private static void solution() {
        int len = (int) Math.pow(2, N);
        recursive(0, 0, 0, len);
    }

    private static int recursive(int y, int x, int val, int size) {
        if (size == 1) {
            if (y == r && x == c) {
                System.out.println(val);
                System.exit(0);
            }
            return val + 1;
        }

        int len = size / 2;
        int[] dy = {0, 0, len, len};
        int[] dx = {0, len, 0, len};

        if (!(y <= r && y + size > r && x <= c && x + size > c)) {
            return val + (size * size);
        }

        for (int i = 0; i < 4; i++) {
            val = recursive(y + dy[i], x + dx[i], val, len);
        }

        return val;
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
