package fc1006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//연결 요소의 개수
public class bj11724 {

    static int n,m;
    static boolean[] isVisited;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n= Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        isVisited = new boolean[n+1];
        graph = new int[n+1][n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b]=graph[b][a]=1;
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (!isVisited[i]) {
                dfs(i);
                answer++;
            }
        }

        System.out.println(answer);
    }

    static void dfs(int depth) {
        if (isVisited[depth]) {
            return;
        } else {
            isVisited[depth]=true;
            for (int i = 1; i <= n; i++) {
                if (graph[depth][i] == 1) {
                    dfs(i);
                }
            }
        }
    }
}
