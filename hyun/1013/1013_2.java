import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int i = 0; i < n; i++) {

            answer++;

            String s = br.readLine();
            int[] arr = new int[26];

            for (int j = 0; j < s.length(); j++) {
                arr[s.charAt(j) - 'a']++;

                if (arr[s.charAt(j) - 'a'] > 1) {
                    if (s.charAt(j) != s.charAt(j - 1)) {
                        answer--;
                        break;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}