import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        input();
        solution();
    }

    static int N, K, Q, M;
    static int[] arrK, arrQ;
    static int[][] se;

    private static void input() {
        ScannerReader sr = new ScannerReader();
        N = sr.nextInt();
        K = sr.nextInt();
        Q = sr.nextInt();
        M = sr.nextInt();

        arrK = new int[K];
        for (int i = 0; i < K; i++) {
            arrK[i] = sr.nextInt();
        }

        arrQ = new int[Q];
        for (int i = 0; i < Q; i++) {
            arrQ[i] = sr.nextInt();
        }

        se = new int[M][2];
        for (int i = 0; i < M; i++) {
            se[i][0] = sr.nextInt();
            se[i][1] = sr.nextInt();
        }
    }

    private static void solution() {
        StringBuilder sb = new StringBuilder();

        // 출석 체크 인원 확인
        boolean[] checked = new boolean[N + 3];
        for (int q : arrQ) {
            if (isContainArrK(q)) continue;

            for (int i = q; i < N + 3; i += q) {
                if (!checked[i] && !isContainArrK(i)) {
                    checked[i] = true;
                }
            }
        }

        // 누적합 계산
        int[] prefixSum = new int[N + 3];
        for (int i = 3; i < N + 3; i++) {
            prefixSum[i] = prefixSum[i - 1] + (checked[i] ? 0 : 1);
        }

        // 출석되지 않은 인원 계산
        for (int i = 0; i < M; i++) {
            sb.append(prefixSum[se[i][1]] - prefixSum[se[i][0] - 1]).append('\n');
        }

        System.out.println(sb);
    }

    private static boolean isContainArrK(int n) {
        for (int k : arrK) {
            if (k == n) {
                return true;
            }
        }
        return false;
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
                } catch (Exception e) {
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
