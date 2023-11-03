import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//좌표정렬하기
public class bj11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] coordinates = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            coordinates[i][0]= Integer.parseInt(st.nextToken()); //x
            coordinates[i][1] = Integer.parseInt(st.nextToken()); //y
        }

        Arrays.sort(coordinates, (n1,n2)->{
            if(n1[1]==n2[1]){ //y 좌표 같을 경우
                return n1[0] - n2[0];
            }
            else{
                return n1[1] - n2[1];
            }
        });

        for (int i = 0; i < n; i++) {
            System.out.println(coordinates[i][0]+" "+coordinates[i][1]);
        }
    }
}
