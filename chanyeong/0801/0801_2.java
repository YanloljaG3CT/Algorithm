import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        input();
        solution();
    }

    static int N, M;
    static int[] selected;
    static StringBuilder sb = new StringBuilder();

    static void input() {
        ScannerReader sr = new ScannerReader();
        N = sr.nextInt();
        M = sr.nextInt();

        selected = new int[M];
    }

    static void solution() {
        DFS(0, 0);
        System.out.println(sb);
    }

    private static void DFS(int n, int L) {
        if (L == M) {
            for (int num : selected) {
                sb.append(num).append(" ");
            }
            sb.append('\n');
            return;
        }

        for (int i = n + 1; i <= N; i++) {
            selected[L] = i;
            DFS(i, L + 1);
        }
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
