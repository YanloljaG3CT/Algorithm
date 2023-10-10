import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p9046 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {

            String s = br.readLine();
            int[] arr = new int[26];
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) >= 'a' && s.charAt(j) <= 'z') arr[s.charAt(j) - 'a']++;
            }

            int max = 0;
            for (int k : arr) {
                if (k > max) max = k;
            }

            int count = 0;
            int answer = 0;
            for (int j = 0; j < 26; j++) {
                if (max == arr[j]) {
                    count++;
                    answer = j;
                }
            }

            System.out.println(count == 1 ? (char) (answer + 'a') : "?");

        }
    }
}