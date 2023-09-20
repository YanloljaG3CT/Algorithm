import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] arr;
    static Integer[][] dp;

    public static void main(String[] args) {
        input();
        solution();
    }

    private static void input() {
        ScannerReader sr = new ScannerReader();
        N = sr.nextInt();

        arr = new int[N][3];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = sr.nextInt();
            }
        }
        dp = new Integer[N][3];
    }

    private static void solution() {
        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            min = Math.min(min, recursive(N - 1, i));
        }
        System.out.println(min);
    }

    private static int recursive(int N, int color) {
        if (dp[N][color] != null) {
            return dp[N][color];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            if (color == i) {
                continue;
            }

            min = Math.min(min, recursive(N - 1, i));
        }

        return dp[N][color] = min + arr[N][color];
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
