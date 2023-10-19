import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, X;
    static int[] arr;

    public static void main(String[] args) {
        input();
        solution();
    }

    private static void input() {
        ScannerReader sr = new ScannerReader();
        N = sr.nextInt();
        X = sr.nextInt();

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sr.nextInt();
        }
    }

    private static void solution() {
        int count = 1;
        int max = Arrays.stream(arr, 0, X)
                .sum();

        int sum = max;
        int left = 0;
        int right = X;
        while (right < N) {
            sum += (arr[right++] - arr[left++]);

            if (sum == max) {
                count++;
            } else if (sum > max) {
                max = sum;
                count = 1;
            }
        }

        if (max == 0) {
            System.out.println("SAD");
            return;
        }

        System.out.println(max);
        System.out.println(count);
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
