import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        input();
        solution();
    }

    static int N, M, left, right;
    static int[] lectures;

    private static void input() {
        ScannerReader sr = new ScannerReader();
        N = sr.nextInt();
        M = sr.nextInt();

        lectures = new int[N];
        for (int i = 0; i < N; i++) {
            lectures[i] = sr.nextInt();
            left = Math.max(left, lectures[i]);
            right += lectures[i];
        }
    }

    private static void solution() {
        while (left <= right) {
            int mid = (left + right) / 2;
            int sum = 0;
            int count = 0;

            for (int lecture : lectures) {
                if (sum + lecture > mid) {
                    count++;
                    sum = 0;
                }
                sum += lecture;
            }
            if (sum > 0) {
                count++;
            }

            if (count > M) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(left);
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
