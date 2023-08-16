import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p10448 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        arr = new int[45];

        for (int i = 1; i <= 44; i++) {
            arr[i] = i * (i + 1) / 2;
        }

        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            int result = search(k);
            System.out.println(result);
        }
    }

    public static int search (int k) {
        for (int i = 1; i <= 44; i++) {
            for (int j = 1; j <= 44; j++) {
                for (int l = 1; l <= 44; l++) {
                    if (arr[i] + arr[j] + arr[l] == k) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }
}