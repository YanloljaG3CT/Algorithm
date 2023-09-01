import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        ScannerReader sr = new ScannerReader();
        int T = sr.nextInt();
        for (int i = 0; i < T; i++) {
            input(sr);
            solution();
        }
    }

    static int N, M;
    static int[] nums, memory;

    private static void input(ScannerReader sr) {
        N = sr.nextInt();

        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sr.nextInt();
        }

        M = sr.nextInt();
        memory = new int[M];
        for (int i = 0; i < M; i++) {
            memory[i] = sr.nextInt();
        }
    }

    private static void solution() {
        Arrays.sort(nums);

        for (int n : memory) {
            System.out.println(binarySearch(n));
        }
    }

    private static int binarySearch(int num) {
        int left = 0;
        int right = N - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] < num) {
                left = mid + 1;
            } else if (nums[mid] > num) {
                right = mid - 1;
            } else {
                return 1;
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
