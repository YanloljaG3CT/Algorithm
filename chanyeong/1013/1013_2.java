import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static String[] words;

    public static void main(String[] args) {
        input();
        solution();
    }

    private static void input() {
        ScannerReader sr = new ScannerReader();
        N = sr.nextInt();

        words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = sr.readLine();
        }
    }

    private static void solution() {
        int answer = 0;
        for (String word : words) {
            answer += checker(word);
        }

        System.out.println(answer);
    }

    static int checker(String word) {
        boolean[] isExist = new boolean[26];
        char prev = '\0';

        for (char c : word.toCharArray()) {
            if (prev != c) {
                if (isExist[c - 'a']) {
                    return 0;
                }

                isExist[c - 'a'] = true;
                prev = c;
            }
        }

        return 1;
    }

    static class ScannerReader {

        private final BufferedReader br;
        private StringTokenizer st;

        public ScannerReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String readLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (Exception e) {
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
