import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int money;

    public static void main(String[] args) {
        input();
        solution();
    }

    private static void input() {
        ScannerReader sr = new ScannerReader();
        money = sr.nextInt();
    }

    private static void solution() {
        if (money == 1 || money == 3) {
            System.out.println(-1);
            return;
        }

        int count = (money / 5);
        money %= 5;
        if (money % 2 == 1) {
            count--;
            money += 5;
        }

        count += (money / 2);
        money %= 2;

        if (money > 0) {
            System.out.println(-1);
            return;
        }

        System.out.println(count);
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
