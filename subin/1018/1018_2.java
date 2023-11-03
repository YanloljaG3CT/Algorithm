import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class bj21921 {

    static int n,x,cnt;
    static Integer[] views, sumArray;

//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        n = Integer.parseInt(st.nextToken());
//        x = Integer.parseInt(st.nextToken());
//        views = new Integer[n];
//        sumArray = new Integer[n - x + 1];
//
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < n; i++) {
//            views[i]= Integer.parseInt(st.nextToken());
//        }
//        sol();
//        Arrays.sort(sumArray, Collections.reverseOrder());
//
//        int max = sumArray[0];
//        if (max == 0) {
//            System.out.println("SAD");
//        } else {
//            System.out.println(max);
//            for (int i : sumArray) {
//                if (i == max) {
//                    cnt++;
//                }
//            }
////            int cnt = Collections.frequency(List.of(sumArray), max);
//            System.out.println(cnt);
//        }
//    }
//
//    public static void sol() {
//        int index =0;
//
//        while (true) {
//            int sum =0;
//            for (int i = 0; i < x; i++) {
//                sum+=views[index+i];
//            }
//
//            sumArray[index]=sum;
//            index++;
//            if (index == n-x+1) {
//                break;
//            }
//        }
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int sum = 0;
        for (int i = 0; i < x; i++) {
            sum += arr[i];
        }

        int max = sum;
        int maxCnt = 1;
        for (int i = x; i < n; i++) {
            sum += arr[i] - arr[i-x];
            if (max == sum) {
                maxCnt++;
            } else if (max < sum) {
                max = sum;
                maxCnt = 1;
            }
        }
        if (max == 0) {
            System.out.println("SAD");
            return;
        }
        System.out.println(max);
        System.out.println(maxCnt);
    }
}
