package fc0831;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class findNum {
    public static int[] existNumArray;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N= Integer.parseInt(br.readLine());
        existNumArray=new int[N];

        st=new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < N; i++) {
            existNumArray[i]= Integer.parseInt(st.nextToken());
        }
        Arrays.sort(existNumArray);

        int M=Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine()," ");
        for (int i = 0; i <M ; i++) {
            System.out.println(binarySearch(Integer.parseInt(st.nextToken())));
        }
    }

    public static int binarySearch(int key){
        int left=0;
        int right=existNumArray.length-1;

        while (left<=right){
            int mid=(left+right)/2;

            if(existNumArray[mid]==key){
                return 1;
            } else if (existNumArray[mid]<key) {
                left=mid+1;
            }else {
                right=mid-1;
            }
        }return 0;
    }
}
