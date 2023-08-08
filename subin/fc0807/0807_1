package fc0807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bingo {
    public static int[][] bingoArr;
    public static int result;
    public static int bingocnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bingoArr = new int[5][5];
        for(int i=0;i<5;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<5;j++){
                bingoArr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<5;i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            for(int j=0;j<5;j++){
                result++;
                int num=Integer.parseInt(st.nextToken());
                deleteNum(num);
                checkBingo();
                if(bingocnt>=3){
                    System.out.println(result);
                    return;
                }
                bingocnt=0;
            }
        }

    }

    public static void deleteNum(int n){
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(bingoArr[i][j]==n){
                    bingoArr[i][j]=-1;
                }
            }
        }
    }

    public static void checkBingo(){
        int diagRight=0; //오른쪽 아래 대각선
        int diagLeft=0; //왼쪽 아래 대각선

        for(int i=0;i<5;i++){
            int row=0;
            int col=0;
            for(int j=0;j<5;j++){
                row+=bingoArr[i][j];
                col+=bingoArr[j][i];
                if(i==j){
                    diagRight+=bingoArr[i][j];
                }
                if(i+j==4){
                    diagLeft+=bingoArr[i][j];
                }
            }
            if(row==-5){
                bingocnt++;
            }
            if(col==-5){
                bingocnt++;
            }
        }
        if(diagRight==-5){
            bingocnt++;
        }
        if(diagLeft==-5){
            bingocnt++;
        }
    }
}
