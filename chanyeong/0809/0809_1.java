import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        input();
        solution();
    }

    static int N;
    static long max, min;
    static int[] nums, opers, arr;

    private static void input() {
        ScannerReader sr = new ScannerReader();
        N = sr.nextInt();

        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sr.nextInt();
        }

        opers = new int[4];
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            sum += opers[i] = sr.nextInt();
        }

        arr = new int[sum];
    }

    public static void solution() {
        max = Long.MIN_VALUE;
        min = Long.MAX_VALUE;
        dfs(0);
        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int L) {
        if (isComplete()) {
            long result = calc();
            max = Math.max(max, result);
            min = Math.min(min, result);
        }

        for (int i = 0; i < 4; i++) {
            if (opers[i] != 0) {
                opers[i]--;
                arr[L] = i;
                dfs(L + 1);
                opers[i]++;
            }
        }
    }

    private static boolean isComplete() {
        return Arrays.stream(opers).noneMatch(oper -> oper > 0);
    }

    private static long calc() {
        long num = nums[0];
        for (int i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case 0:
                    num = num + nums[i + 1];
                    break;
                case 1:
                    num = num - nums[i + 1];
                    break;
                case 2:
                    num = num * nums[i + 1];
                    break;
                case 3:
                    num = num / nums[i + 1];
                    break;
            }
        }
        return num;
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
