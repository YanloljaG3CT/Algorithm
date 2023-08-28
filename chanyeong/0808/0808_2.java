import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        input();
        solution();
    }

    static int N;
    static int[][] arr;

    private static void input() {
        ScannerReader sr = new ScannerReader();
        N = sr.nextInt();

        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sr.nextInt();
            }
        }
    }

    static int min = Integer.MAX_VALUE;
    static boolean[] visited;

    public static void solution() {
        visited = new boolean[N];
        dfs(0, 0);
        System.out.println(min);
    }

    static void dfs(int index, int L) {
        if (L == N / 2) {
            int difference = calc();
            if (difference == 0) {
                System.out.println(difference);
                System.exit(0);
            }

            min = Math.min(min, difference);
            return;
        }

        for (int i = index; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, L + 1);
                visited[i] = false;
            }
        }
    }

    private static int calc() {
        int teamA = 0;
        int teamB = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    teamA += arr[i][j];
                    teamA += arr[j][i];
                }

                if (!visited[i] && !visited[j]) {
                    teamB += arr[i][j];
                    teamB += arr[j][i];
                }
            }
        }

        return Math.abs(teamA - teamB);
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
