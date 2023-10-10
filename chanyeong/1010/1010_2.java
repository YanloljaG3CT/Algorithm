import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        input();
        solution();
    }

    static int T;
    static String[] arr;

    private static void input() {
        ScannerReader sr = new ScannerReader();
        T = sr.nextInt();

        arr = new String[T];
        for (int i = 0; i < T; i++) {
            arr[i] = sr.readLine();
        }
    }

    private static void solution() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int[] count = new int[26];
            for (char c : arr[i].toCharArray()) {
                if (!Character.isAlphabetic(c)) {
                    continue;
                }

                count[c - 'a']++;
            }

            int max = 0;
            char answer = '\0';
            for (int j = 0; j < 26; j++) {
                if (count[j] == max) {
                    answer = '?';
                }

                if (count[j] > max) {
                    max = count[j];
                    answer = (char) ('a' + j);
                }
            }

            sb.append(answer).append('\n');
        }

        System.out.println(sb);
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
