import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p20116 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[] x = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            x[i] = Integer.parseInt(st.nextToken());
        }

        double[] sum = new double[n];
        sum[0] = x[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + x[i];
        }

        for (int i = 0; i < n - 1; i++) {
            double v = (sum[n - 1] - sum[i]) / (n -1 -i);
            if (v <= x[i] - l || v >= x[i] + l) {
                System.out.print("unstable");
                return;
            }
        }
        System.out.print("stable");
    }
}