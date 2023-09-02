package fc0821;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class candy {
    public static char[][] board;
    public static int N;
    public static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N= Integer.parseInt(br.readLine());
        board=new char[N][N];

        //board 채우기
        for(int i=0;i<N;i++){
            st= new StringTokenizer(br.readLine());
            String candy=st.nextToken();
            for(int j=0;j<N;j++){
                board[i][j]=candy.charAt(j);
            }
        }

        //가로로 두 문자 교환
        for(int i=0;i<N;i++){
            for(int j=0;j<N-1;j++){
                swap(i,j,i,j+1);
                maxCandy();
                //교환한거 되돌리기
                swap(i,j+1,i,j);
            }
        }
        //세로로 두 문자 교환
        for(int i=0;i<N-1;i++){
            for(int j=0;j<N;j++){
                swap(i,j,i+1,j);
                maxCandy();
                //교환한거 되돌리기
                swap(i+1,j,i,j);
            }
        }

        System.out.println(max);

    }

    //두 문자 교환하는 swap 메서드
    public static void swap(int a1,int a2,int b1,int b2){
        char temp=board[a1][a2];
        board[a1][a2]=board[b1][b2];
        board[b1][b2]=temp;
    }

    //최대 사탕 개수 찾기
    public static void maxCandy(){
        //가로로 탐색
        for(int i=0;i<N;i++){
            int cnt=1;
            for(int j=0;j<N-1;j++){
                if(board[i][j]==board[i][j+1]){
                    cnt++;
                    max=Math.max(cnt,max);
                }
                else{
                    cnt=1;
                }
            }
        }

        //세로로 탐색
        for(int i=0;i<N;i++){
            int cnt=1;
            for(int j=0;j<N-1;j++){
                if(board[j][i]==board[j+1][i]){
                    cnt++;
                    max=Math.max(cnt,max);
                }
                else{
                    cnt=1;
                }
            }
        }
    }
}
