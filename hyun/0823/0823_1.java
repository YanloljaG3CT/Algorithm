import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class p1018 {

    public static boolean[][] board;
    public static int min = 64;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        board = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = (s.charAt(j) == 'W');
            }
        }

        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                search(i, j);
            }
        }

        System.out.println(min);
    }


    public static void search(int x, int y) {
        int count = 0;

        boolean v = board[x][y];

        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {

                if (board[i][j] != v) {
                    count++;
                }
                v = !v;
            }

            v = !v;
        }

        int WB = Math.min(count, 64 - count);

        min = Math.min(min, WB);
    }
}