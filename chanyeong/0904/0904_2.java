import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        input();
        solution();
    }

    static int N, K;
    static int[] A;

    static void input() {
        ScannerReader sr = new ScannerReader();
        N = sr.nextInt();
        K = sr.nextInt();

        A = new int[N];
        for (int i = N - 1; i >= 0; i--) {
            A[i] = sr.nextInt();
        }
    }

    static void solution() {
        int cnt = 0;

        for (int coin : A) {
            if (coin <= K) {
                cnt += (K / coin);
                K %= coin;
            }
        }

        System.out.println(cnt);
    }

    static class ScannerReader {
        private final BufferedReader br;
        private StringTokenizer st;

        public ScannerReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        private String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
