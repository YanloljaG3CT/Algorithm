import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static Integer[] dp;

    public static void main(String[] args) {
        input();
        solution();
    }

    private static void input() {
        ScannerReader sr = new ScannerReader();
        N = sr.nextInt();

        dp = new Integer[N + 1];
    }

    private static void solution() {
        dp[0] = dp[1] = 0;
        System.out.println(recursive(N));
    }

    private static int recursive(int N) {
        if (dp[N] == null) {
            if (N % 6 == 0) {
                dp[N] = Math.min(recursive(N / 3), Math.min(recursive(N / 2), recursive(N - 1))) + 1;
            } else if (N % 3 == 0) {
                dp[N] = Math.min(recursive(N / 3), recursive(N - 1)) + 1;
            } else if (N % 2 == 0) {
                dp[N] = Math.min(recursive(N / 2), recursive(N - 1)) + 1;
            } else {
                dp[N] = recursive(N - 1) + 1;
            }
        }

        return dp[N];
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
