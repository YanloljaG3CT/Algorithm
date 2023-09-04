import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int L, P, V;

    public static void main(String[] args) {
        ScannerReader sr = new ScannerReader();
        int index = 1;

        while (true) {
            L = sr.nextInt();
            P = sr.nextInt();
            V = sr.nextInt();

            if (L == 0 && P == 0 && V == 0) {
                break;
            }
            solution(index++);
        }
    }

    private static void solution(int index) {
        int total = (V / P) * L + Math.min((V % P), L);
        System.out.println("Case " + index + ": " + total);
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
