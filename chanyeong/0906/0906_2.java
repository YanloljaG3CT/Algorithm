import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, L;
    static int[] holes;

    public static void main(String[] args) {
        input();
        solution();
    }

    private static void input() {
        ScannerReader sr = new ScannerReader();
        N = sr.nextInt();
        L = sr.nextInt();

        holes = new int[N];
        for (int i = 0; i < N; i++) {
            holes[i] = sr.nextInt();
        }
    }

    private static void solution() {
        Arrays.sort(holes);

        int count = 0;
        int tape = -1;
        for (int i = 0; i < N; i++) {
            if (holes[i] > tape) {
                count++;
                tape = holes[i] + (L - 1);
            }
        }

        System.out.println(count);
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
