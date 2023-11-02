import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//수들의 합 2
public class bj2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());
        int[] numArray = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numArray[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        int start =0;
        int end = 0;
        int sum = numArray[0];

        while (true) {
            if (sum >= num) {
                if (sum == num) {
                    cnt++;
                }
                sum -= numArray[start++];
            } else {
                end++;
                if (end == n) {
                    break;
                }
                sum += numArray[end];
            }
        }
        System.out.println(cnt);
    }
}
