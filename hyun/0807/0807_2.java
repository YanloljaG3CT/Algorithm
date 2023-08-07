import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p20546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int base = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[14];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int timingstock = 0;
        int timingmoney = base;
        for (int i = 3; i < arr.length; i++) {
            if (arr[i - 3] < arr[i - 2] && arr[i - 2] < arr[i - 1] && arr[i - 1] < arr[i]) {
                if (timingstock > 0) {
                    timingmoney += arr[i] * timingstock;
                    timingstock = 0;
                }
            }
            if (arr[i - 3] > arr[i - 2] && arr[i - 2] > arr[i - 1] && arr[i - 1] > arr[i]) {
                timingstock += timingmoney / arr[i];
                timingmoney = timingmoney % arr[i];
            }
        }
        int t = (arr[13] * timingstock) + timingmoney;

        int bnpstock = 0;
        int bnpmoney = base;
        for (int i = 0; i < arr.length; i++) {
            if (bnpmoney >= arr[i]) {
                bnpstock += bnpmoney / arr[i];
                bnpmoney = bnpmoney % arr[i];
            }
        }
        int b = (arr[13] * bnpstock) + bnpmoney;

        System.out.println(t + " " + b);
        if (b < t) System.out.println("TIMING");
        else if (t < b) System.out.println("BNP");
        else System.out.println("SAMESAME");
    }
}