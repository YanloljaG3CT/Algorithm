import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        input();
        solution();
    }

    static int N, M;
    static int[] cards, target;

    private static void input() {
        ScannerReader sr = new ScannerReader();
        N = sr.nextInt();

        cards = new int[N];
        for (int i = 0; i < N; i++) {
            cards[i] = sr.nextInt();
        }

        M = sr.nextInt();
        target = new int[M];
        for (int i = 0; i < M; i++) {
            target[i] = sr.nextInt();
        }
    }

    private static void solution() {
        Arrays.sort(cards);
        int[] clone = target.clone();
        Arrays.sort(clone);

        Map<Integer, Integer> count = new HashMap<>();

        int cardIndex = 0;
        int targetIndex = 0;

        while (cardIndex < N && targetIndex < M) {
            if (cards[cardIndex] < clone[targetIndex]) {
                cardIndex++;
            } else if (cards[cardIndex] > clone[targetIndex]) {
                targetIndex++;
            } else {
                count.put(clone[targetIndex], count.getOrDefault(clone[targetIndex], 0) + 1);
                cardIndex++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int n : target) {
            sb.append(count.getOrDefault(n, 0)).append(" ");
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
