import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int A, B, C;

    public static void main(String[] args) {
        input();
        solution();
    }

    private static void input() {
        ScannerReader sr = new ScannerReader();
        A = sr.nextInt();
        B = sr.nextInt();
        C = sr.nextInt();
    }

    private static void solution() {
        System.out.println(recursive(B));
    }

    private static long recursive(long exponent) {
        if (exponent == 1) {
            return A % C;
        }

        long tmp = recursive(exponent / 2);
        if (exponent % 2 == 1) {
            return (tmp * tmp % C) * A % C;
        }
        return tmp * tmp % C;
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
