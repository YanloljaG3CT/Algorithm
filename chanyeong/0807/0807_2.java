import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        input();
        solution();
    }

    static int N = 14;
    static int money;
    static int[] arr;

    private static void input() {
        ScannerReader sr = new ScannerReader();
        money = sr.nextInt();

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sr.nextInt();
        }
    }

    public static void solution() {
        Equity jh = new Equity(money);
        Equity sm = new Equity(money);
        int day = 0;

        for (int i = 0; i < N; i++) {
            // 준현
            if (jh.money >= arr[i]) {
                jh.buyStock(arr[i]);
            }

            // 성민
            if (i == 0) {
                continue;
            }
            day = stockChangeDay(day, arr[i - 1], arr[i]);

            if (day >= 3) {
                sm.buyStock(arr[i]);
            } else if (day <= -3) {
                sm.saleStock(arr[i]);
            }
        }

        System.out.println(compareTo(jh.total(arr[N - 1]), sm.total(arr[N - 1])));
    }

    private static int stockChangeDay(int day, int yesterday, int today) {
        if (yesterday < today) {
            // 주식 상승
            if (day < 0) {
                day = 1;
            } else {
                day++;
            }
        } else if (yesterday > today) {
            // 주식 하강
            if (day > 0) {
                day = -1;
            } else {
                day--;
            }
        } else {
            day = 0;
        }
        return day;
    }

    private static String compareTo(int jh, int sm) {
        if (jh > sm) {
            return "BNP";
        } else if (jh < sm) {
            return "TIMING";
        }
        return "SAMESAME";
    }

    static class Equity {
        int money;
        int stockCnt;

        public Equity(int money) {
            this.money = money;
        }

        public void buyStock(int stockPrice) {
            stockCnt += money / stockPrice;
            money = money % stockPrice;
        }

        public void saleStock(int stockPrice) {
            money += (stockCnt * stockPrice);
            this.stockCnt = 0;
        }

        public int total(int stockPrice) {
            return (stockCnt * stockPrice) + money;
        }
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
