import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] cities, distances;

    public static void main(String[] args) {
        input();
        solution();
    }

    private static void input() {
        ScannerReader sr = new ScannerReader();
        N = sr.nextInt();

        distances = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            distances[i] = sr.nextInt();
        }

        cities = new int[N];
        for (int i = 0; i < N; i++) {
            cities[i] = sr.nextInt();
        }
    }

    private static void solution() {
        int minCity = Integer.MAX_VALUE;
        BigInteger totalPrice = BigInteger.ZERO;

        for (int i = 0; i < N - 1; i++) {
            minCity = Math.min(minCity, cities[i]);
            totalPrice = totalPrice.add(BigInteger.valueOf((long) minCity * distances[i]));
        }

        System.out.println(totalPrice);
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
