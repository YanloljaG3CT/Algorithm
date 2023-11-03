package fc0922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//포도주 시식
public class bj2156 {
    static int n;
    static int[] drinks,dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n= Integer.parseInt(br.readLine());

        drinks = new int[n+1];
        dp=new int[n+1];

        for (int i = 1; i <= n; i++) {
            drinks[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = drinks[1];
        if (n > 1) {
            dp[2]=drinks[1]+drinks[2];
        }
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + drinks[i], dp[i - 3] + drinks[i - 1] + drinks[i]));
        }

        System.out.println(dp[n]);
    }
}
