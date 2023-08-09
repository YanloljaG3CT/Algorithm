package fc0808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class startLink {

    public static int n,start,link;
    public static int result = Integer.MAX_VALUE;
    public static int[][] ability;
    public static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n=Integer.parseInt(br.readLine());
        ability=new int[n][n];
        isVisited=new boolean[n];

        for(int i =0;i<n;i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                ability[i][j]= Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,0);
        System.out.println(result);
    }

    //팀 조합
    public static void dfs(int idx,int depth){
        //반을 탐색
        if(depth==n/2){
            calDiff();
            return;
        }
        for(int i=idx;i<n;i++){
            if(!isVisited[i]){
                isVisited[i]=true;
                dfs(i+1,depth+1);
                isVisited[i]=false;
            }
        }
    }

    //차이값 계산
    public static void calDiff(){
        start=0;
        link=0;
        for(int i=0;i<n-1;i++){
            for(int j=i;j<n;j++){
                if(isVisited[i]==true&&isVisited[j]==true){
                    start+=ability[i][j];
                    start+=ability[j][i];
                } else if (isVisited[i]==false&&isVisited[j]==false) {
                    link+= ability[i][j];
                    link+= ability[j][i];
                }
            }
        }
        int diff=Math.abs(start-link);
        result=Math.min(diff,result);
    }


}
