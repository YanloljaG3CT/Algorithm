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
        dp[0] = 0;
        dp[1] = 1;
        if (N == 1) {
            System.out.println(1);
            return;
        }

        dp[2] = 2;
        int result = recursive(N) % 10007;
        System.out.println(result);
    }

    private static int recursive(int N) {
        if (dp[N] == null) {
            dp[N] = (recursive(N - 1) + recursive(N - 2)) % 10007;
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
