import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//회전 초밥
public class bj2531 {
    static int[] sushi, types;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int cnt = 0;
        sushi = new int[n];
        types = new int[d + 1];

        for (int i = 0; i < n; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < k; i++) {
            if (types[sushi[i]] == 0) {
                cnt++;
            }
            types[sushi[i]]++; //해당 종류의 스시 먹었다는 뜻
        }

        int max = cnt;
        for (int i = 1; i < n; i++) { //i = start 인 셈
            if (max <= cnt) {
                if (types[c] == 0) {
                    max = cnt + 1;
                } else {
                    max = cnt;
                }
            }

            int end = (i + k - 1) % n;
            if (types[sushi[end]] == 0) {
                cnt++;
            }
            types[sushi[end]]++;

            types[sushi[i - 1]]--; //이전 초밥 제거
            if (types[sushi[i - 1]] == 0) {
                cnt--;
            }
        }
        System.out.println(max);

    }
}
