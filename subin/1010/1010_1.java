
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//복호화
public class bj9046 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int[] alphabet = new int[123];
            String str = br.readLine();
            char[] strArray = str.toCharArray();

            for (int s : strArray) {
                if (s >= 'a' && s <= 'z') {
                    alphabet[s]++;
                }
            }

            int max = 0;
            char maxIndex = '?';

            for (char c = 'a'; c <= 'z'; c++) {
                if (alphabet[c] > max) {
                    max = alphabet[c];
                    maxIndex = c;
                } else if (alphabet[c] == max) {
                    maxIndex = '?';
                }
            }

            System.out.println(maxIndex);
        }
    }
}
