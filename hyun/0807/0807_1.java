import java.util.Scanner;

public class p2578 {
    static int[][] arr;
    static int bingo;
    static int sum;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = new int[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < 25; i++) {
            int v = sc.nextInt();

            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (arr[j][k] == v) arr[j][k] = 0;
                }
            }

            x(v);
            y(v);
            if (arr[0][0] + arr[1][1] + arr[2][2] + arr[3][3] + arr[4][4] == 0) bingo++;
            if (arr[0][4] + arr[1][3] + arr[2][2] + arr[3][1] + arr[4][0] == 0) bingo++;

            if (bingo >= 3) {
                System.out.println(i + 1);
                break;
            }
            bingo = 0;
        }
    }

    public static void x(int v) {
        for (int i = 0; i < 5; i++) {
            sum = 0;
            for (int j = 0; j < 5; j++) {
                sum += arr[i][j];
            }
            if (sum == 0) bingo++;
        }
    }
    public static void y(int v) {
        for (int i = 0; i < 5; i++) {
            sum = 0;
            for (int j = 0; j < 5; j++) {
                sum += arr[j][i];
            }
            if (sum == 0) bingo++;
        }
    }
}