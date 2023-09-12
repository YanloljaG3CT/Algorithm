package fc0912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1992 {
    public static int[][] video;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        video = new int[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                video[i][j] = line.charAt(j) - '0';
            }
        }

        printCompressionResult(n, 0, 0);
        System.out.println(sb.toString());
    }

    public static void printCompressionResult(int size, int x, int y) {
        if (check(size, x, y)) {
            sb.append(video[x][y]);
            return;
        }
        sb.append("(");

        printCompressionResult(size / 2, x, y); //왼쪽 위
        printCompressionResult(size / 2, x, y + size / 2); //왼쪽 아래
        printCompressionResult(size / 2, x + size / 2, y); //오른쪽 위
        printCompressionResult(size / 2, x + size / 2, y + size / 2); //오른쪽 아래

        sb.append(")");
    }

    public static boolean check(int size, int x, int y) {
        int curr = video[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (video[i][j] != curr) {
                    return false;
                }
            }
        }
        return true;
    }
}
