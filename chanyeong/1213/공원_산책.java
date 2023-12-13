import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = getStart(park);

        int height = park.length;
        int width = park[0].length();

        Map<String, int[]> direct = new HashMap<>();
        direct.put("N", new int[]{-1, 0});
        direct.put("S", new int[]{1, 0});
        direct.put("W", new int[]{0, -1});
        direct.put("E", new int[]{0, 1});

        for(String route : routes) {
            String[] split = route.split(" ");

            int len = Integer.parseInt(split[1]);
            boolean flag = true;
            int ny = answer[0];
            int nx = answer[1];
            for(int i=0; i<len; i++) {
                ny += direct.get(split[0])[0];
                nx += direct.get(split[0])[1];

                if(ny < 0 || ny >= height || nx < 0 || nx >= width || park[ny].charAt(nx) == 'X') {
                    flag = false;
                    break;
                }
            }

            if(flag) {
                answer = new int[]{ny, nx};
            }
        }

        return answer;
    }

    private static int[] getStart(String[] park) {
        for(int i=0; i<park.length; i++) {
            for(int j=0; j<park[0].length(); j++) {
                if(park[i].charAt(j) == 'S') {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }
}
