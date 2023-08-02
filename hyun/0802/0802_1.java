import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p15649 {

    public static int n;
    public static int m;
    public static int[] arr;
    public static boolean[] v;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        v = new boolean[n];

        dfs(0);
        System.out.println(sb);
    }

    public static void dfs (int depth) {
        if (depth == m) {
            for (int val : arr) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!v[i]) {
                v[i] = true;
                arr[depth] = i + 1;
                dfs(depth + 1);
                v[i] = false;
            }
        }
    }
}