import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        input();
        solution();
    }

    static int N = 5;
    static int[] nums, checked;
    static Point[] board;

    private static void input() {
        ScannerReader sr = new ScannerReader();

        board = new Point[(N + 1) * (N + 2)];
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                board[sr.nextInt()] = new Point(i, j);
            }
        }

        nums = new int[N * N];
        for (int i = 0; i < N * N; i++) {
            nums[i] = sr.nextInt();
        }
    }

    public static void solution() {
        int cnt = 0;

        checked = new int[(N + 1) * 2];
        Arrays.fill(checked, N);

        for (int n : nums) {
            cnt++;
            if (isBingo(board[n])) {
                System.out.println(cnt);
                return;
            }
        }
    }

    private static boolean isBingo(Point point) {
        bingoChecked(point);
        return Arrays.stream(checked)
                .filter(n -> n == 0)
                .count() >= 3;
    }

    private static void bingoChecked(Point point) {
        checked[point.x]--;
        checked[point.y + N]--;

        if (point.y == point.x) {
            checked[0]--;
        }
        if (point.y + point.x == N + 1) {
            checked[(N * 2) + 1]--;
        }
    }

    static class Point {

        int y, x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
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
