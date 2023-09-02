package fc0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class chessColoring {
    public static char[][] board;
    public static int N,M;
    public static int minDiff = Integer.MAX_VALUE;

    public static char[][] whiteChessBoard = new char[][]{
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'}
    };

    public static char[][] blackChessBoard = new char[][]{
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        board=new char[N][M];
        //보드판 채우기
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            String color = st.nextToken();
            for(int j=0;j<M;j++){
                board[i][j]=color.charAt(j);
            }
        }
        countDiff();
        System.out.println(minDiff);
    }


    public static void countDiff(){
        for(int i=0;i<=N-8;i++){
            for(int j=0;j<=M-8;j++){
                int count1=0; //whiteChessBoard랑 비교
                int count2=0; //blackChessBoard랑 비교


                for(int k=0;k<8;k++){
                    for(int l=0;l<8;l++){
                        if(board[i+k][j+l]!=whiteChessBoard[k][l]){
                            count1++;
                        }
                        if(board[i+k][j+l]!=blackChessBoard[k][l]){
                            count2++;
                        }
                    }
                }
                minDiff=Math.min(minDiff,Math.min(count1,count2));
            }
        }
    }


}
