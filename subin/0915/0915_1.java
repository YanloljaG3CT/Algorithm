package fc0915;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1074 {
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, n);
        divide(size,r,c);
    }

    public static void divide(int size, int r, int c) {
        if (size == 1) {
            System.out.println(cnt);
            return;
        }

        int n = size/2;
        // 1사분면
        if (r < n && c < n) {
            cnt += 0; // n*n*0
            divide(n,r,c);
        } 
        // 2사분면
        else if (r < n && c < n + n) {
            cnt += n * n; //n*n*1
            divide(n,r,c-n);
        }
        // 3사분면
        else if (r < n + n && c < n) {
            cnt += n * n * 2;
            divide(n,r-n,c);
        }
        // 4사분면
        else {
            cnt += n * n * 3;
            divide(n,r-n,c-n);
        }
    }
}
