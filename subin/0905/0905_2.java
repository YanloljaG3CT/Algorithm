package fc0905;

import java.util.Arrays;
import java.util.Scanner;

public class bj2217 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int[] ropes = new int[n];

        for (int i = 0; i < n; i++) {
            ropes[i]=scanner.nextInt();
        }
        Arrays.sort(ropes);

        int maxWeight = 0;
        for (int i = n-1; i >= 0 ; i--) {
            maxWeight = Math.max(maxWeight, ropes[i] * (n - i));
        }

        System.out.println(maxWeight);
    }
}
