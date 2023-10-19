import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] A, B;

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

        B = new int[M];
        for (int i = 0; i < M; i++) {
            B[i] = sr.nextInt();
        }
    }

    private static void solution() {
        int[] answer = new int[N + M];
        int idx = 0;
        int aIdx = 0;
        int bIdx = 0;

        while (aIdx < N && bIdx < M) {
            if (A[aIdx] < B[bIdx]) {
                answer[idx++] = A[aIdx++];
            } else {
                answer[idx++] = B[bIdx++];
            }
        }

        while (aIdx < N) {
            answer[idx++] = A[aIdx++];
        }

        while (bIdx < M) {
            answer[idx++] = B[bIdx++];
        }

        StringBuilder sb = new StringBuilder();
        Arrays.stream(answer)
                .sorted()
                .forEach(n -> sb.append(n).append(" "));
        System.out.println(sb);
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
