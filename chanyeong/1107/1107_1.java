import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] map;

    public static void main(String[] args) {
        input();
        solution();
    }

    private static void input() {
        ScannerReader sr = new ScannerReader();
        N = sr.nextInt();
        M = sr.nextInt();

        map = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            String row = sr.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = Character.getNumericValue(row.charAt(j - 1));
            }
        }
    }

    private static void solution() {
        int max = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[i][j] > 0) {
                    map[i][j] = Math.min(map[i - 1][j], Math.min(map[i - 1][j - 1], map[i][j - 1])) + 1;
                    max = Math.max(max, map[i][j]);
                }
            }
        }

        System.out.println(max * max);
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
