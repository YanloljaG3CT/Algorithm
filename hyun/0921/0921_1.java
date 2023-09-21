import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] seq = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        int[] memo = new int[n];
        Arrays.fill(memo, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (seq[j] < seq[i]) {
                    memo[i] = Math.max(memo[j] + 1, memo[i]);
                }
            }
        }

        int result = Arrays.stream(memo).max().getAsInt();
        System.out.println(result);
    }
}