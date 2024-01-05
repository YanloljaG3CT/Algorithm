import java.util.*;

class Solution {

    static int height, width;
    static boolean[][] visited;

    public List<Integer> solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        height = maps.length;
        width = maps[0].length();
        visited = new boolean[height][width];

        for(int i=0; i<height; i++) {
            for(int j=0; j<width; j++) {
                if(!visited[i][j] && maps[i].charAt(j) != 'X') {
                    answer.add(bfs(maps, new int[] {i, j}));
                }
            }
        }

        if(answer.isEmpty()) {
            return List.of(-1);
        }

        Collections.sort(answer);
        return answer;
    }

    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};

    private int bfs(String[] maps, int[] start) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);

        visited[start[0]][start[1]] = true;
        int sum = maps[start[0]].charAt(start[1]) - '0';

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for(int i=0; i<4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];

                if(ny >=0 && ny < height && nx >= 0 && nx < width) {
                    if(!visited[ny][nx] && maps[ny].charAt(nx) != 'X') {
                        q.offer(new int[]{ny, nx});
                        visited[ny][nx] = true;
                        sum += maps[ny].charAt(nx) - '0';
                    }
                }
            }
        }

        return sum;
    }
}
