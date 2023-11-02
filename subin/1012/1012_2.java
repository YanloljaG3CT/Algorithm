import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//나는 친구가 적다
public class bj16171 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String findStr = br.readLine();
        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (c >= 'A' && c <= 'z') {
                sb.append(c);
            }
        }
        String brString = sb.toString();
        if(brString.contains(findStr)){
            System.out.println(1);
        }else {
            System.out.println(0);
        }

    }
}
