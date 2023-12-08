class Solution {
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};

    public int solution(int[][] board) {
        int answer = 0;
        int height = board.length;
        int width = board[0].length;

        for(int i=0; i<height; i++) {
            for(int j=0; j<width; j++) {
                if(board[i][j] == -1) continue;

                if(board[i][j] == 0) {
                    answer++;
                    board[i][j] = -99;
                    continue;
                }

                for(int k=0; k<8; k++) {
                    int ny = i + dy[k];
                    int nx = j + dx[k];

                    if(ny >= 0 && ny < height && nx >= 0 && nx < width) {
                        if(board[ny][nx] == 1) continue;

                        if(board[ny][nx] == -99){
                            answer--;
                        }
                        board[ny][nx] = -1;
                    }
                }
            }
        }

        return answer;
    }
}
