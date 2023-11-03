

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//랜선자르기
public class bj1654 {
    static long[] lines;
    static long right, left=1, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        lines = new long[k];

        for (int i = 0; i < k; i++) {
            lines[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, lines[i]); //가장 큰 값 저장
        }
        count(n);
        System.out.println(answer);
    }

    public static void count(int n) {
        while (left <= right) {
            long mid = (left + right) / 2;
            int cnt = 0;
            for (long line : lines) {
                cnt+= (int) (line/mid);
            }
            if (cnt >= n) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }
    }
}
