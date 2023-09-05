import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static Integer[] rope;

    public static void main(String[] args) {
        input();
        solution();
    }

    private static void input() {
        ScannerReader sr = new ScannerReader();
        N = sr.nextInt();

        rope = new Integer[N];
        for (int i = 0; i < N; i++) {
            rope[i] = sr.nextInt();
        }
    }

    private static void solution() {
        Arrays.sort(rope, Collections.reverseOrder());

        int index = 0;
        for (Integer min : rope) {
            rope[index] = min * (index + 1);
            index++;
        }

        int result = Arrays.stream(rope)
                .mapToInt(n -> n)
                .max()
                .orElse(0);

        System.out.println(result);
    }

    static class ScannerReader {

        private final BufferedReader br;
        private StringTokenizer st;

        public ScannerReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String readLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "";
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
