import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p2776 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < t; i++) {
            StringBuilder sb = new StringBuilder();
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            int[] arr = new int[n];

            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            int m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());

                sb.append(binarySearch(arr, num)).append("\n");
            }
            System.out.print(sb);
        }
    }

    static int binarySearch(int[] arr, int num) {

        int lo = 0;
        int hi = arr.length - 1;
        int mid;

        while (lo <= hi) {

            mid = (lo + hi) / 2;

            if (num > arr[mid]) {
                lo = mid + 1;
            } else if (num == arr[mid]) {
                return 1;
            } else {
                hi = mid - 1;
            }

        }
        return 0;
    }
}