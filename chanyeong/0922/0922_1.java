import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;
    static Integer[] dp;

    public static void main(String[] args) {
        input();
        solution();
    }

    private static void input() {
        ScannerReader sr = new ScannerReader();
        N = sr.nextInt();

        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = sr.nextInt();
        }
        dp = new Integer[N + 1];
    }

    private static void solution() {
        if (N == 1) {
            System.out.println(arr[1]);
            return;
        }

        dp[N] = arr[N];
        System.out.println(recursive(0));
    }

    private static int recursive(int idx) {
        if (idx > N) {
            return 0;
        }

        if (dp[idx] == null) {
            dp[idx] = Math.max(Math.max(recursive(idx + 2), recursive(idx + 3) + arr[idx + 1]) + arr[idx], recursive(idx + 1));
        }

        return dp[idx];
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
