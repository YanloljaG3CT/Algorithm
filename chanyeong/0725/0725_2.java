import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        input();
        solution();
    }

    static int N, L;
    static int[] arr;

    static void input() {
        ScannerReader sr = new ScannerReader();
        N = sr.nextInt();
        L = sr.nextInt();

        arr = new int[N];
        for (int i = N - 1; i >= 0; i--) {
            arr[i] = sr.nextInt();
        }
    }

    static void solution() {
        long sum = 0;

        for (int i = 0; i < N - 1; i++) {
            sum += arr[i];
            int min = arr[i + 1] - L;
            int max = arr[i + 1] + L;

            double center = (double) sum / (i + 1);

            if (center <= min || center >= max){
                System.out.println("unstable");
                return;
            }
        }

        System.out.println("stable");
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
