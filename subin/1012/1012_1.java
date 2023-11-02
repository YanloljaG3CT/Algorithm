import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//세로읽기
public class bj10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[][] strArr = new char[5][15];

        for (int i = 0; i < 5; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                strArr[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if (strArr[j][i] != '\0') {
                    sb.append(strArr[j][i]);
                }
            }
        }
        System.out.println(sb);
    }
}
