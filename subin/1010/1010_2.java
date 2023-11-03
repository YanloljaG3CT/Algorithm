
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//스페셜 져지
public class bj9253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        String answer = br.readLine();

        if (str1.contains(answer) && str2.contains(answer)) {
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }

    }
}
