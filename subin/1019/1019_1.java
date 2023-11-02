package fc1019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//배열 합치기
public class bj11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] result = new int[n + m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            result[i]= Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = n; i < n + m; i++) {
            result[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(result);
        for (int i :
                result) {
            sb.append(i + " ");
        }
        System.out.println(sb);

        int[] array1 = new int[n];
        int[] array2 = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            array2[i] = Integer.parseInt(st.nextToken());
        }

        int pointer1 = 0;
        int pointer2 = 0;

        while (pointer1 < n && pointer2 < m) {
            if (array1[pointer1] < array2[pointer2]) {
                sb.append(array1[pointer1]+" ");
                pointer1++;
            } else {
                sb.append(array2[pointer2]+" ");
                pointer2++;
            }
        }

        if (pointer1 == n) {
            for (int i = pointer2; i < m; i++) {
                sb.append(array2[i]+" ");
            }
        }

        if (pointer2 == m) {
            for (int i = pointer1; i < n; i++) {
                sb.append(array1[i]+" ");
            }
        }
        System.out.println(sb);
    }

}
