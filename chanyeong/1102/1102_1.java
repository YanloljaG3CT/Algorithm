import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        input();
        solution();
    }

    static int N;
    static String[] symbols;

    static void input() {
        ScannerReader sr = new ScannerReader();
        N = sr.nextInt();

        symbols = new String[N];
        for (int i = 0; i < N; i++) {
            symbols[i] = sr.next();
        }
    }

    static long max;
    static long min = Long.MAX_VALUE;
    static int[] answer;
    static boolean[] checked;

    static void solution() {
        answer = new int[N + 1];
        checked = new boolean[10];
        dfs(0);

        String format = "%0" + (N + 1) + "d";
        System.out.printf(format + "%n", max);
        System.out.printf(format + "%n", min);
    }

    private static void dfs(int L) {
        if (L == N + 1) {
            long number = 0;
            for (int n : answer) {
                number = (number * 10) + n;
            }
            updateResult(number);
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (!checked[i] && (L == 0 || compare(i, L - 1))) {
                checked[i] = true;
                answer[L] = i;
                dfs(L + 1);
                checked[i] = false;
            }
        }
    }

    private static boolean compare(int n, int index) {
        if (symbols[index].equals(">")) {
            return answer[index] > n;
        }
        return answer[index] < n;
    }

    private static void updateResult(long number) {
        max = Math.max(max, number);
        min = Math.min(min, number);
    }


    static class ScannerReader {

        private final BufferedReader br;
        private StringTokenizer st;

        public ScannerReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        private String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
