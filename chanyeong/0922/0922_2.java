import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static char[] Y, X;
    static Integer[][] dp;

    public static void main(String[] args) {
        input();
        solution();
    }

    private static void input() {
        ScannerReader sr = new ScannerReader();
        Y = sr.readLine().toCharArray();
        X = sr.readLine().toCharArray();

        dp = new Integer[Y.length][X.length];
    }

    private static void solution() {
        System.out.println(LCS(Y.length - 1, X.length - 1));
    }

    private static int LCS(int y, int x) {
        if (y < 0 || x < 0) {
            return 0;
        }

        if (dp[y][x] == null) {
            dp[y][x] = Y[y] == X[x]
                    ? LCS(y - 1, x - 1) + 1
                    : Math.max(LCS(y - 1, x), LCS(y, x - 1));
        }

        return dp[y][x];
    }

    static class ScannerReader {

        private final BufferedReader br;

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
    }
}
