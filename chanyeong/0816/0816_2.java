import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        input();
        solution();
    }

    static int N;
    static int[] arr;

    private static void input() {
        ScannerReader sr = new ScannerReader();
        N = sr.nextInt();

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sr.nextInt();
        }
    }

    static int[] T;

    private static void solution() {
        T = new int[45];
        for (int i = 1; i < 45; i++) {
            T[i] = (i * (i + 1)) / 2;
        }

        for (int n : arr) {
            System.out.println(eureka(n));
        }
    }

    private static int eureka(int n) {
        for (int i = 1; i < 45; i++) {
            for (int j = i; j < 45; j++) {
                for (int k = j; k < 45; k++) {
                    if (T[i] + T[j] + T[k] == n) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

    static class ScannerReader {

        private final BufferedReader br;
        private StringTokenizer st;

        public ScannerReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String readLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }

            return str;
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
