import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        input();
        solution();
    }

    static int N;
    static int[] nums;

    static void input() {
        ScannerReader sr = new ScannerReader();
        N = sr.nextInt();

        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sr.nextInt();
        }
    }

    static void solution() {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(nums)
                .sorted()
                .forEach(num -> sb.append(num).append('\n'));
        System.out.println(sb);
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
