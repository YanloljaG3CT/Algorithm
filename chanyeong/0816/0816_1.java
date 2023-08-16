import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        input();
        solution();
    }

    static int N;

    private static void input() {
        ScannerReader sr = new ScannerReader();
        N = sr.nextInt();
    }

    private static void solution() {
        if (N < 10) {
            if (N % 2 == 0) {
                System.out.println(N / 2);
                return;
            }
        }

        int len = (int) Math.log(N);
        int num = N - (10 * len);
        while (num < N) {
            int result = calc(num);
            if (result == N) {
                System.out.println(num);
                return;
            }
            num++;
        }

        System.out.println(0);
    }

    private static int calc(int num) {
        int sum = num;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
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
