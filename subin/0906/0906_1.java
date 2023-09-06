package fc0906;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj13305 {
    public static int n;
    public static int[] oilPrice, distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        oilPrice = new int[n];
        distance = new int[n - 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            oilPrice[i] = Integer.parseInt(st.nextToken());
        }

        long sum=0;
        int minPrice = oilPrice[0];
        for (int i = 0; i < n - 1; i++) {
            if(oilPrice[i]<minPrice){
                minPrice=oilPrice[i];
            }
            sum += ((long) minPrice * distance[i]);
        }
        System.out.println(sum);
    }
}
