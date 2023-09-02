package fc0829;

import java.util.Arrays;
import java.util.Scanner;

public class budget {
    private static int[] requestBudget; // 지방 예산
    private static long answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 지방의 수
        requestBudget = new int[N];
        for (int i = 0; i < N; i++) {
            requestBudget[i] = sc.nextInt();
        }
        Arrays.sort(requestBudget);

        long M = sc.nextLong();
        long left = 0;
        long right = requestBudget[N-1];
        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;
            for (int money : requestBudget) {
                if (money >= mid) sum += mid;
                else sum += money;
            }
            if (sum > M) {
                right = mid - 1;
            } else {
                left = mid + 1;
                answer = Math.max(answer, mid);
            }
        }
        System.out.println(answer);
    }
}
