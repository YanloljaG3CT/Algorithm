import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        input();
        solution();
    }

    static int N;
    static int[] queens;

    static void input() {
        ScannerReader sr = new ScannerReader();
        N = sr.nextInt();
    }

    static void solution() {
        queens = new int[N];
        int cnt = DFS(0);
        System.out.println(cnt);
    }

    private static int DFS(int L) {
        if (L == N) {
            return 1;
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (isValid(L, i)) {
                queens[L] = i;
                cnt += DFS(L + 1);
            }
        }

        return cnt;
    }

    private static boolean isValid(int y, int x) {
        for (int i = y - 1; i >= 0; i--) {
            int queen = queens[i];
            if (x == queen
                    || x == queen - (y - i)
                    || x == queen + (y - i)
            ) {
                return false;
            }
        }
        return true;
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
