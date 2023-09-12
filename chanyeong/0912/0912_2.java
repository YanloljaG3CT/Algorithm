import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] result = {0, 0, 0};
    static int[][] arr;

    public static void main(String[] args) {
        input();
        solution();
    }

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

    private static void solution() {
        recursive(0, 0, N);
        Arrays.stream(result)
                .forEach(System.out::println);
    }

    private static void recursive(int y, int x, int l) {
        if (isPossible(y, x, l)) {
            result[arr[y][x] + 1]++;
            return;
        }

        if (l == 3) {
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < l; j++) {
                    result[arr[y + i][x + j] + 1]++;
                }
            }
            return;
        }

        int len = l / 3;
        for (int i = 0; i < 3; i++) {
            int ny = y + (i * len);
            for (int j = 0; j < 3; j++) {
                int nx = x + (j * len);
                recursive(ny, nx, len);
            }
        }
    }

    private static boolean isPossible(int y, int x, int len) {
        int paper = arr[y][x];

        for (int i = y; i < y + len; i++) {
            for (int j = x; j < x + len; j++) {
                if (arr[i][j] != paper) {
                    return false;
                }
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
