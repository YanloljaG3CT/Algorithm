package fc0801;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class nm2 {
    public static int N,M;
    public static boolean[] isVisited;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());

        isVisited=new boolean[N];
        arr=new int[M];

        dfs(0,0);
    }

    public static void dfs(int cur,int cnt){
        if(cnt==M){
            for (int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i=cur;i<N;i++){
            if(!isVisited[i]){
                isVisited[i]=true;
                arr[cnt]=i+1;
                dfs(i+1,cnt+1);
                isVisited[i]=false;
            }
        }
    }
}
