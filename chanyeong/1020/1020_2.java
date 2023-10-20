import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] arr;

    public static void main(String[] args) {
        input();
        solution();
    }

    private static void input() {
        ScannerReader sr = new ScannerReader();
        N = sr.nextInt();
        M = sr.nextInt();

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sr.nextInt();
        }
    }

    private static void solution() {
        Arrays.sort(arr);

        int count = 0;
        int left = 0;
        int right = N - 1;
        while (left < right) {
            if (arr[left] + arr[right] < M) {
                left++;
            } else if (arr[left] + arr[right] > M) {
                right--;
            } else {
                count++;
                left++;
                right--;
            }
        }

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
