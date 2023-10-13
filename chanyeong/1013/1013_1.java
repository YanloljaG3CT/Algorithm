import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static String[] listeners, watchers;

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void input() throws IOException {
        ScannerReader sr = new ScannerReader();
        N = sr.nextInt();
        M = sr.nextInt();

        listeners = new String[N];
        for (int i = 0; i < N; i++) {
            listeners[i] = sr.readLine();
        }

        watchers = new String[M];
        for (int i = 0; i < M; i++) {
            watchers[i] = sr.readLine();
        }
    }

    private static void solution() {
        Map<String, Integer> count = new HashMap<>();
        for (int i = 0; i < N; i++) {
            count.put(listeners[i], count.getOrDefault(listeners[i], 0) + 1);
        }

        for (int i = 0; i < M; i++) {
            count.put(watchers[i], count.getOrDefault(watchers[i], 0) + 1);
        }

        List<String> result = new ArrayList<>();
        for (Entry<String, Integer> entry : count.entrySet()) {
            if (entry.getValue() > 1) {
                result.add(entry.getKey());
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append('\n');
        result.stream()
                .sorted()
                .forEach(name -> sb.append(name).append('\n'));
        System.out.println(sb);
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
