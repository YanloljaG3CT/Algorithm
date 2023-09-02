package fc0831;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class guitarLesson {
    public static int N,M,min,max;
    public static int[] lectureArray;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input=br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        lectureArray = new int[N];

        StringTokenizer st=new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < N; i++) {
            lectureArray[i]= Integer.parseInt(st.nextToken());
            min=Math.max(min,lectureArray[i]);
            max+=lectureArray[i];
        }
        System.out.println(binarySearch());

    }
    public static int binarySearch(){
        int left=min;
        int right=max;

        while (left<=right){
            int mid=(left+right)/2;
            int sum=0;
            int cnt=0;
            for (int lecture:lectureArray) {
                //설정한 값보다 합이 크다면 블루레이 쪼개야함
                if(sum+lecture>mid){
                    sum=0;
                    cnt++;
                }
                sum+=lecture;
            }
            //마지막 블루레이 개수 세주기
            if(sum!=0){
                cnt++;
            }
            if(cnt>M){
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
        return left;
    }
}
