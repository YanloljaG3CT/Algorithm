import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        char[][] parks = new char[park.length][park[0].length()];


        //시작 위치 구하기, parks 배열 만들기
        int x = 0, y = 0;
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                parks[i][j] = park[i].charAt(j);
                if (parks[i][j] == 'S') {
                    x = j;
                    y = i;
                }
            }
        }

        //길 찾기
        String[] dir = new String[routes.length];
        int[] length = new int[routes.length];
        for (int i = 0; i < routes.length; i++) {
            dir[i] = routes[i].split(" ")[0];
            length[i] = Integer.parseInt(routes[i].split(" ")[1]);
        }

        char now = 0;
        int nx = x;
        int ny = y;
        for (int i = 0; i < routes.length; i++) {
            for (int j = 1; j <= length[i]; j++) {
                switch (dir[i]) {
                    case "E":
                        if (x + length[i] >= park[0].length()) break;
                        now = parks[y][x + j];
                        nx = x + j;
                        break;
                    case "W":
                        if (x - length[i] < 0) break;
                        now = parks[y][x - j];
                        nx = x - j;
                        break;
                    case "S":
                        if (y + length[i] >= park.length) break;
                        now = parks[y + j][x];
                        ny = y + j;
                        break;
                    case "N":
                        if (y - length[i] < 0) break;
                        now = parks[y - j][x];
                        ny = y - j;
                        break;
                }
                if (now == 'X' || now == 0) {
                    nx = x;
                    ny = y;
                    break;
                }
            }
            if (now != 'X' && now != 0) {
                x = nx;
                y = ny;
            }
        }
        
        return new int[]{y, x};
    }
}
