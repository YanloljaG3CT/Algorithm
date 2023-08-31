import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        input();
        solution();
    }

    static int N, M;
    static Integer[] trees;

    private static void input() {
        ScannerReader sr = new ScannerReader();
        N = sr.nextInt();
        M = sr.nextInt();

        trees = new Integer[N];
        for (int i = 0; i < N; i++) {
            trees[i] = sr.nextInt();
        }
    }

    private static void solution() {
        Arrays.sort(trees, Collections.reverseOrder());

        int sum = 0;
        int max = trees[0];
        int index = 0;

        while (max >= 0) {
            while (index < trees.length && trees[index] > max) {
                index++;
            }
            sum += index;

            if (sum >= M) {
                break;
            }

            max--;
        }

        System.out.println(max == -1 ? 0 : max);
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
