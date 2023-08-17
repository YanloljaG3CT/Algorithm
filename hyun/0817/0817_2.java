import java.util.Scanner;

public class p2503 {
    static int[] arr = new int[504];
    static int[][] check;
    static int count = 0;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        save();
        n = sc.nextInt();
        check = new int[n][3];

        for (int i = 0; i < n; i++) {
            check[i][0] = sc.nextInt();
            check[i][1] = sc.nextInt();
            check[i][2] = sc.nextInt();
        }

        counting();
        System.out.println(count);
    }

    public static void counting() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < n; j++) {
                boolean v = checking(arr[i], check[j][0], check[j][1], check[j][2]);
                if (!v) break;
                else if (j == n - 1) count++;
            }
        }
    }

    public static boolean checking(int x, int y, int st, int ba) {
        int strike = 0;
        int ball = 0;

        if (x / 100 == y / 100) strike++;
        if (x / 10 % 10 == y / 10 % 10) strike++;
        if (x % 10 == y % 10) strike++;

        if (x / 100 == y / 10 % 10 || x / 100 == y % 10) ball++;
        if (x / 10 % 10 == y / 100 || x / 10 % 10 == y % 10) ball++;
        if (x % 10 == y / 100 || x % 10 == y / 10 % 10) ball++;

        return strike == st && ball == ba;
    }

    public static void save() {
        int cnt = 0;
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if (j != i) {
                    for (int k = 1; k <= 9; k++) {
                        if (k != j && k != i) {
                            arr[cnt] = (i * 100) + (j * 10) + k;
                            cnt++;
                        }
                    }
                }
            }
        }
    }
}