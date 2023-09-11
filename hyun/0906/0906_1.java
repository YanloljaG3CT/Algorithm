import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] distance = new int[n - 1];
        for (int i = 0; i < distance.length; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }

        int[] gasPrice = new int[n - 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < gasPrice.length; i++) {
            gasPrice[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(st.nextToken());

        long result = 0;
        long minCost = gasPrice[0];

        for (int i = 0; i < n - 1; i++) {

            minCost = Math.min(minCost, gasPrice[i]);

            result += (minCost * distance[i]);

        }

        System.out.println(result);
    }
}