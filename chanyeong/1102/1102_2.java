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
    static Coordinate[] coordinates;

    static void input() {
        ScannerReader sr = new ScannerReader();
        N = sr.nextInt();

        coordinates = new Coordinate[N];
        for (int i = 0; i < N; i++) {
            int x = sr.nextInt();
            int y = sr.nextInt();
            coordinates[i] = new Coordinate(x, y);
        }
    }

    static void solution() {
        Arrays.sort(coordinates);

        StringBuilder sb = new StringBuilder();
        Arrays.stream(coordinates)
                .forEach(coordinate -> sb.append(coordinate.x).append(" ").append(coordinate.y).append('\n'));
        System.out.println(sb);
    }

    static class Coordinate implements Comparable<Coordinate> {
        private final int x, y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Coordinate o) {
            if (y == o.y) {
                return x - o.x;
            }
            return y - o.y;
        }
    }

    static class ScannerReader {

        private final BufferedReader br;
        private StringTokenizer st;

        public ScannerReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        private String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
