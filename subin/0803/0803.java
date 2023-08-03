package fc0803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class lotto {

    public static int k;
    public static int[] S,result;
    public static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            StringTokenizer st=new StringTokenizer(br.readLine());
            k=Integer.parseInt(st.nextToken());
            if(k==0){
                break;
            }

            S=new int[k];
            for(int i=0;i<k;i++){
                S[i]= Integer.parseInt(st.nextToken());
            }

            result=new int[6];
            isVisited=new boolean[k];
            dfs(0,0);
            System.out.println();
        }
    }

    public static void dfs(int cur,int cnt){
        if (cnt==6){
            for (int i = 0; i < 6; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i=cur;i<k;i++){
            if(!isVisited[i]){
                isVisited[i]=true;
                result[cnt]=S[i];
                dfs(i,cnt+1);
                isVisited[i]=false;
            }
        }
    }

}
