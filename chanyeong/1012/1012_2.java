import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        input();
        solution();
    }

    static int maxLen;
    static String[] arr;

    private static void input() {
        ScannerReader sr = new ScannerReader();

        maxLen = Integer.MIN_VALUE;
        arr = new String[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = sr.readLine();
            maxLen = Math.max(maxLen, arr[i].length());
        }
    }

    static void solution() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < maxLen; i++) {
            for (int j = 0; j < 5; j++) {
                if (arr[j].length() > i) {
                    sb.append(arr[j].charAt(i));
                }
            }
        }

        System.out.println(sb);
    }

    static class ScannerReader {
        private final BufferedReader br;

        public ScannerReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        private String readLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }

            return str;
        }
    }
}
