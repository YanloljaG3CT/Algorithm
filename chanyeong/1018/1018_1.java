import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] A;

    public static void main(String[] args) {
        input();
        solution();
    }

    private static void input() {
        ScannerReader sr = new ScannerReader();
        N = sr.nextInt();
        M = sr.nextInt();

        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sr.nextInt();
        }
    }

    private static void solution() {
        int answer = 0;
        int left = 0;
        int right = 0;

        int sum = 0;
        while (true) {
            if (sum >= M) {
                sum -= A[left++];
            } else {
                if (right == N) {
                    break;
                }
                sum += A[right++];
            }

            if (sum == M) {
                answer++;
            }
        }

        System.out.println(answer);
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
