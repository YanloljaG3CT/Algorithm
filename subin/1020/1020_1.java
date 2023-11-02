import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//주몽
public class bj1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] nums = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        int start =0;
        int end =n-1;
        int cnt=0;

        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum < m) {
                start++;
            } else if (sum > m) {
                end--;
            } else {
                cnt++;
                start++;
            }
        }

        System.out.println(cnt);

    }
}
