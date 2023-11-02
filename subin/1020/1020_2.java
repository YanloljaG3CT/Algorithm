import java.util.Scanner;

//수들의 합 5
public class bj2018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nArray = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            nArray[i] = i;
        }

        int start = 1;
        int end = 1;
        int sum = 0;
        int cnt = 1;

        while (end < n + 1) {
            if (sum == n) {
                cnt++;
                sum += nArray[end];
                end++;
            } else if (sum < n) {
                sum += nArray[end];
                end++;
            } else {
                sum -= nArray[start];
                start++;
            }
        }
        System.out.println(cnt);

    }
}
