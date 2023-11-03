import java.io.BufferedReader;
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
    static int[] A, B;

    static void input(ScannerReader sr) {
        N = sr.nextInt();
        M = sr.nextInt();

        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sr.nextInt();
        }

        B = new int[M];
        for (int i = 0; i < M; i++) {
            B[i] = sr.nextInt();
        }
    }

    static void solution() {
        // A, B 배열 오름차순 정렬
        Arrays.sort(A);
        Arrays.sort(B);

        int result = 0;
        int left = 0;
        int right = 0;

        while (left < N && right < M) {
            // A[left]의 원소가 B[right]의 원소보다 크면 카운트(B의 다음 원소로 이동)
            if (A[left] > B[right]) {
                right++;
                continue;
            }

            // A[left]의 원소가 B[right]의 원소보다 작거나 같다면, 카운트 한 값(현재 B의 인덱스) 결과에 더한다.
            result += right;
            left++;
        }

        // 비교하지 못한 A의 남은 원소들은 B의 모든 원소보다 큰 값이므로, 모두 결과에 더해준다.
        result += (N - left) * right;

        System.out.println(result);
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

        private String next() {
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
