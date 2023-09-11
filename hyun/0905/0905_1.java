import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p14916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 1 || n == 3) System.out.println(-1);

        for (int i = (n / 5); i >= 0; i--) {
            if ((n - (i * 5)) % 2 == 0) {
                System.out.println(i + ((n - (i * 5)) / 2));
                break;
            }
        }
    }
}