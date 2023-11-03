import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        input();
        solution();
    }

    static int N;
    static SerialNumber[] serialNumbers;

    static void input() {
        ScannerReader sr = new ScannerReader();
        N = sr.nextInt();

        serialNumbers = new SerialNumber[N];
        for (int i = 0; i < N; i++) {
            String serialNumber = sr.readLine();
            serialNumbers[i] = new SerialNumber(serialNumber);
        }
    }

    static void solution() {
        // 시리얼 번호 정렬
        Arrays.sort(serialNumbers);

        StringBuilder sb = new StringBuilder();
        Arrays.stream(serialNumbers)
                .forEach(serialNumber -> sb.append(serialNumber.number).append('\n'));
        System.out.println(sb);
    }

    static class SerialNumber implements Comparable<SerialNumber> {

        private final String number;

        public SerialNumber(String number) {
            this.number = number;
        }

        @Override
        public int compareTo(SerialNumber o) {
            // 시리얼 번호의 길이가 같다면
            if (number.length() == o.number.length()) {
                int sum = numberSum(number);
                int target = numberSum(o.number);

                // 시리얼 번호의 모든 숫자의 합이 같다면
                if (sum == target) {
                    // 사전순 정렬
                    return number.compareTo(o.number);
                }

                // 시리얼 번호의 모든 숫자의 합으로 정렬
                return sum - target;
            }

            // 시리얼 번호의 길이로 정렬
            return number.length() - o.number.length();
        }
    }

    public static int numberSum(String serialNumber) {
        int sum = 0;
        for (char c : serialNumber.toCharArray()) {
            if (Character.isDigit(c)) {
                sum += (c - '0');
            }
        }
        return sum;
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

        private String next() {
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
