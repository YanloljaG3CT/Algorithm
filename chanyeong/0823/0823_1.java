import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        input();
        solution();
    }

    static int N, max;
    static int[][] arr;
    static boolean[] visited;

    private static void input() {
        ScannerReader sr = new ScannerReader();
        N = sr.nextInt();

        arr = new int[N + 1][2];
        for (int i = 1; i < N + 1; i++) {
            arr[i][0] = sr.nextInt();
            arr[i][1] = sr.nextInt();
        }

        visited = new boolean[N + 1];
        max = Integer.MIN_VALUE;
    }

    public static void solution() {
        dfs(1, 0);
        System.out.println(max);
    }

    static void dfs(int next, int cost) {
        if (next > N + 1) {
            return;
        }
        if (next == N + 1) {
            max = Math.max(max, cost);
            return;
        }

        dfs(next + arr[next][0], cost + arr[next][1]);
        dfs(next + 1, cost);
    }

    static private class ScannerReader {

        private final BufferedReader br;
        private StringTokenizer st;

        public ScannerReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String readLine() {
            String str = "";

            try {
                str = br.readLine();
            } catch (IOException e) {
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
