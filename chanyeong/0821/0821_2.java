import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        input();
        solution();
    }

    static int N;
    static int[] questions, strikes, balls;

    private static void input() {
        ScannerReader sr = new ScannerReader();
        N = sr.nextInt();

        questions = new int[N];
        strikes = new int[N];
        balls = new int[N];

        for (int i = 0; i < N; i++) {
            questions[i] = sr.nextInt();
            strikes[i] = sr.nextInt();
            balls[i] = sr.nextInt();
        }
    }

    private static void solution() {
        boolean[] checked = new boolean[1000];

        for (int i = 0; i < N; i++) {
            for (int j = 123; j < 1000; j++) {
                if (checked[j]) {
                    continue;
                }

                int[] nums = divideNum(j);

                if (nums[1] == 0 || nums[2] == 0
                        || nums[0] == nums[1] || nums[0] == nums[2] || nums[1] == nums[2]) {
                    checked[j] = true;
                    continue;
                }

                if (!isMatch(i, nums)) {
                    checked[j] = true;
                }
            }
        }

        int count = 0;
        for (int i = 123; i < 1000; i++) {
            if (!checked[i]) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static int[] divideNum(int num) {
        int n1 = num / 100;
        num %= 100;
        int n2 = num / 10;
        int n3 = num % 10;
        return new int[]{n1, n2, n3};
    }

    private static boolean isMatch(int index, int[] nums) {
        int strikeCount = 0;
        int ballCount = 0;

        int[] h = divideNum(questions[index]);

        for (int i = 0; i < 3; i++) {
            if (h[i] == nums[i]) {
                strikeCount++;
                continue;
            }

            if (nums[i] == h[0] || nums[i] == h[1] || nums[i] == h[2]) {
                ballCount++;
            }
        }

        return strikeCount == strikes[index] && ballCount == balls[index];
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
