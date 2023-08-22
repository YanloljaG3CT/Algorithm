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

    static int N;
    static int[][][] coins;

    private static void input() {
        ScannerReader sr = new ScannerReader();
        N = sr.nextInt();

        coins = new int[N][3][3];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    coins[i][j][k] = sr.next().equals("H") ? 1 : 0;
                }
            }
        }
    }

    static int[] flip = {448, 56, 7, 292, 146, 73, 273, 84};

    private static void solution() {
        for (int[][] coin : coins) {
            System.out.println(bfs(coin));
        }
    }

    private static int bfs(int[][] coin) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[512];
        int start = parseIntToBinary(coin);
        q.offer(start);
        visited[start] = true;
        int cnt = 0;

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int cur = q.poll();
                if (cur == 0 || cur == 511) {
                    return cnt;
                }

                for (int num : flip) {
                    int next = cur ^ num;

                    if (!visited[next]) {
                        visited[next] = true;
                        q.offer(next);
                    }
                }
            }
            cnt++;
        }

        return -1;
    }

    private static int parseIntToBinary(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(board[i][j]);
            }
        }

        return Integer.parseInt(sb.toString(), 2);
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
