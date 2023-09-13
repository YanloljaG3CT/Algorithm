import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;

    public static void main(String[] args) {
        input();
        solution();
    }

    private static void input() {
        ScannerReader sr = new ScannerReader();
        N = sr.nextInt();
        M = sr.nextInt();
    }

    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb;

    private static void solution() {
        arr = new int[M];
        visited = new boolean[N + 1];
        sb = new StringBuilder();
        recursive(0);
        System.out.println(sb);
    }

    private static void recursive(int L) {
        if (L == M) {
            Arrays.stream(arr)
                    .forEach(n -> sb.append(n).append(" "));
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[L] = i;
                recursive(L + 1);
                visited[i] = false;
            }
        }
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
