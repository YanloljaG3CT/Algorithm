import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int k;
    static int[] S;

    static int N = 6;
    static int[] result = new int[N];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        ScannerReader sr = new ScannerReader();

        while (true) {
            k = sr.nextInt();
            if (k == 0) {
                break;
            }

            S = new int[k];
            for (int i = 0; i < k; i++) {
                S[i] = sr.nextInt();
            }

            Arrays.sort(S);
            DFS(0, 0);

            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void DFS(int idx, int L) {
        if (L == 6) {
            Arrays.stream(result).forEach(num -> sb.append(num).append(" "));
            sb.append('\n');
            return;
        }

        for (int i = idx; i < k - (N - L - 1); i++) {
            result[L] = S[i];
            DFS(i + 1, L + 1);
        }
    }

    static private class ScannerReader {

        private final BufferedReader br;
        private StringTokenizer st;

        public ScannerReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String readLine() {
            String str = "";

            try {
                str = br.readLine();
            } catch (IOException e) {
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
