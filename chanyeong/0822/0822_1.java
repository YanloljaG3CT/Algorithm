import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        input();
        solution();
    }

    static int N, M;
    static String[] board;

    private static void input() {
        ScannerReader sr = new ScannerReader();
        N = sr.nextInt();
        M = sr.nextInt();

        board = new String[N];
        for (int i = 0; i < N; i++) {
            board[i] = sr.readLine();
        }
    }

    private static void solution() {
        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i <= (N - 8); i++) {
            for (int j = 0; j <= (M - 8); j++) {
                int count = check(i, j);
                minCount = Math.min(minCount, count);

                if (minCount == 0) {
                    System.out.println(0);
                    return;
                }
            }
        }

        System.out.println(minCount);
    }

    static char[] colors = {'W', 'B'};

    private static int check(int y, int x) {
        int aCount = 0;
        int bCount = 0;

        for (int i = y; i < y + 8; i++) {
            int aStart = i % 2;
            int bStart = (i + 1) % 2;
            for (int j = x; j < x + 8; j++) {
                char c = board[i].charAt(j);
                if (colors[aStart] != c) {
                    aCount++;
                }

                if (colors[bStart] != c) {
                    bCount++;
                }

                aStart = (aStart + 1) % 2;
                bStart = (bStart + 1) % 2;
            }
        }

        return Math.min(aCount, bCount);
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
