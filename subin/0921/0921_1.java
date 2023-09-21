package fc0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//가장 긴 증가하는 부분 수열
public class bj11053 {
    static int[] num,dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        num = new int[n];
        dp = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i]= Integer.parseInt(st.nextToken());
        }

        //dp 채우기
        for (int i = 0; i < n; i++) {
            subsequence(i);
        }

        //최대값 찾기
        Arrays.sort(dp);
        System.out.println(dp[n-1]);
    }

    public static int subsequence(int n) {
        if (dp[n] == 0) {
            dp[n]=1;

            for (int i = n-1; i >= 0 ; i--) {
                if(num[i]<num[n]){ //현재 n번째 수보다 더 작은 수를 발견했을때(1을 더해줘야함)
                    dp[n]=Math.max(dp[n],subsequence(i)+1);
                }
            }
        }
        return dp[n];
    }
}
