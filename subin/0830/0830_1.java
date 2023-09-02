package fc0830;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NumberCard2 {
    public static int[] numCard;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        int N= Integer.parseInt(br.readLine());
        numCard=new int[N];

        st=new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < N; i++) {
            numCard[i]= Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numCard);

        int M= Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();

        st=new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < M; i++) {
            int num= Integer.parseInt(st.nextToken());
            sb.append(maxBound(numCard,num)-minBound(numCard,num)).append(' ');
        }
        System.out.println(sb);

    }
    public static int minBound(int[] arr,int num){
        int min=0;
        int max=arr.length;

        while (min<max){
            int mid=(min+max)/2;
            if(num<=arr[mid]){
                max=mid;
            }
            else {
                min=mid+1;
            }
        }
        return min;
    }
    public static int maxBound(int[] arr,int num){
        int min=0;
        int max=arr.length;

        while (min<max){
            int mid=(min+max)/2;
            if(num<arr[mid]){
                max=mid;
            }
            else {
                min=mid+1;
            }
        }
        return min;
    }

}
