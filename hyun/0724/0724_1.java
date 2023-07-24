import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class p20438 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[] v = new boolean[n + 3];
        List<Integer> SleepStudent = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < k; i++) {
            SleepStudent.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < q; i++) {
            int now = Integer.parseInt(st.nextToken());
            if (SleepStudent.contains(now)) continue;
            if (!v[now]) {
                for (int j = now; j < n + 3; j++) {
                    if (j % now == 0) {
                        if (!SleepStudent.contains(j)) {
                            v[j] = true;
                        }
                    }
                }
            }
        }

        int[] sum = new int[n + 3];
        for (int i = 3; i < sum.length; i++) {
            sum[i] = sum[i - 1] + ((!v[i]) ? 1 : 0);
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            System.out.println(sum[e] - sum[s - 1]);
        }
    }
}