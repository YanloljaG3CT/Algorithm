package fc0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class omok {
    public static int[][] board;
    public static int[][] fourDirection = {{0,1},{1,0},{1,1},{-1,1}}; //아래. 오른쪾. 오른쪽 대각선아래. 왼쪽 대각선아래
    public static int winner,winnerX,winnerY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //바둑판 입력
        board=new int[19][19];
        for (int i = 0; i < 19; i++) {
            st=new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        check();
        System.out.println(winner);
        System.out.println(winnerX+" "+winnerY);
    }

    public static void check(){
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if(board[i][j]==1||board[i][j]==2){
                    //5개가 연달아 있는지 확인하기
                    for (int k = 0; k < 4; k++) {
                        int x=i;
                        int y=j;
                        int cnt=1;

                        while (true) {
                            x += fourDirection[k][0];
                            y += fourDirection[k][1];
                            if ( 0 <= x && x < 19 && 0 <= y && y < 19) { //바둑판 크기 넘어가면 안됨
                                if(board[i][j] == board[x][y]){
                                    cnt ++;
                                }
                                else {
                                    break;
                                }
                            } else break;
                        }

                        x=i;
                        y=j;

                        //6개 이상 연속으로 놓인경우 찾기
                        while( true) {
                            x -= fourDirection[k][0];
                            y -= fourDirection[k][1];
                            if ( 0 <= x && x < 19 && 0 <= y && y < 19) {
                                if(board[i][j] == board[x][y]){
                                    cnt ++;
                                }
                                else{
                                    break;
                                }
                            } else break;
                        }

                        x=i;
                        y=j;

                        if (cnt == 5) {
                            winner = board[i][j];
                            winnerX = i + 1;
                            winnerY = j + 1;
                            break;
                        }
                    }
                }
            }
        }
    }
}
