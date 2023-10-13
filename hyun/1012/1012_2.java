import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p16171 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String s = "";
        String find = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            if (!(str.charAt(i) - '0' >= 0 && str.charAt(i) - '0' <= 9))
                s += str.charAt(i);
        }
        System.out.println(s.contains(find) ? 1 : 0);
    }
}