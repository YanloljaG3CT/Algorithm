import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        input();
        solution();
    }

    static int N, level;
    static int[][] board;
    static boolean[][] visited;
    static Point shark;

    private static void input() {
        ScannerReader sr = new ScannerReader();
        N = sr.nextInt();

        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int status = sr.nextInt();
                board[i][j] = status;

                if (status == 9) {
                    shark = new Point(i, j);
                    board[i][j] = 0;
                }
            }
        }
    }

    static int[] dy = {-1, 0, 0, 1};
    static int[] dx = {0, -1, 1, 0};

    public static void solution() {
        level = 2;
        int time = 0;
        int exp = 0;

        while (true) {
            shark = bfs(shark);
            if (shark == null) {
                break;
            }

            board[shark.y][shark.x] = 0;
            time += shark.time;

            exp++;
            if (exp == level) {
                level++;
                exp = 0;
            }
        }

        System.out.println(time);
    }

    private static Point bfs(Point shark) {
        PriorityQueue<Point> eatFish = new PriorityQueue<>();

        Queue<Point> q = new LinkedList<>();
        visited = new boolean[N][N];
        visited[shark.y][shark.x] = true;

        int time = 0;
        q.offer(shark);

        while (!q.isEmpty()) {
            time++;
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Point cur = q.poll();

                for (int j = 0; j < 4; j++) {
                    int ny = cur.y + dy[j];
                    int nx = cur.x + dx[j];

                    if (ny >= 0 && ny < N && nx >= 0 && nx < N
                            && !visited[ny][nx] && board[ny][nx] <= level
                    ) {
                        if (board[ny][nx] > 0 && board[ny][nx] < level) {
                            eatFish.offer(new Point(ny, nx, time));
                        } else {
                            visited[ny][nx] = true;
                            q.offer(new Point(ny, nx));
                        }
                    }
                }
            }

            if (eatFish.size() > 0) {
                break;
            }
        }

        return eatFish.isEmpty() ? null : eatFish.poll();
    }

    static class Point implements Comparable<Point> {

        int y, x, time;

        public Point(int y, int x) {
            this(y, x, 0);
        }

        public Point(int y, int x, int time) {
            this.y = y;
            this.x = x;
            this.time = time;
        }

        @Override
        public int compareTo(Point o) {
            if(y == o.y) return x - o.x;
            return y - o.y;
        }
    }

    static private class ScannerReader {

        private final BufferedReader br;
        private StringTokenizer st;

        public ScannerReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String readLine() {
            String str = "";

            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return str;
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(readLine());
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
