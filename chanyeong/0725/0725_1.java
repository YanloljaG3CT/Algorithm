import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        input();
        solution();
    }

    static int N;
    static Time[] times;

    static void input() {
        ScannerReader sr = new ScannerReader();
        N = sr.nextInt();

        times = new Time[N];
        for (int i = 0; i < N; i++) {
            int start = sr.nextInt();
            int end = sr.nextInt();

            times[i] = new Time(start, end);
        }
    }

    static void solution() {
        int cnt = 0;

        Arrays.sort(times);
        int end = 0;
        for (Time time : times) {
            if (time.start >= end) {
                end = time.end;
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    static class Time implements Comparable<Time> {
        int start;
        int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time o) {
            if(this.end == o.end) return this.start - o.start;
            return this.end - o.end;
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
