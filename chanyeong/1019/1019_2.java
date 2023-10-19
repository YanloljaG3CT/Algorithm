import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, d, k, c;
    static int[] sushi;

    public static void main(String[] args) {
        input();
        solution();
    }

    private static void input() {
        ScannerReader sr = new ScannerReader();
        N = sr.nextInt();
        d = sr.nextInt();
        k = sr.nextInt();
        c = sr.nextInt();

        sushi = new int[N];
        for (int i = 0; i < N; i++) {
            sushi[i] = sr.nextInt();
        }
    }

    private static void solution() {
        int[] count = new int[d + 1];
        count[c]++;
        int size = 1;
        for (int i = 0; i < k; i++) {
            if (count[sushi[i]] == 0) {
                size++;
            }
            count[sushi[i]]++;
        }

        int max = size;
        int left = 0;
        int right = k;
        while (left < N) {
            count[sushi[left]]--;
            if (count[sushi[left]] == 0) {
                size--;
            }

            if (count[sushi[right]] == 0) {
                size++;
            }
            count[sushi[right]]++;

            max = Math.max(max, size);

            left++;
            right = (right + 1) % N;
        }

        System.out.println(max);
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
