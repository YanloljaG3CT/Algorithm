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

    static int N, M;
    static int[] A, nums;

    private static void input() {
        ScannerReader sr = new ScannerReader();
        N = sr.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sr.nextInt();
        }

        M = sr.nextInt();
        nums = new int[M];
        for (int i = 0; i < M; i++) {
            nums[i] = sr.nextInt();
        }
    }

    private static void solution() {
        Arrays.sort(A);

        for (int num : nums) {
            System.out.println(binarySearch(num));
        }
    }

    private static int binarySearch(int num) {
        int left = 0;
        int right = N - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (A[mid] < num) {
                left = mid + 1;
            } else if (A[mid] > num) {
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
