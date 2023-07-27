import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(
                4,
                new int[][]{{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}}
        ));
    }

    public int solution(int n, int[][] costs) {
        List<List<Node>> nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nodes.add(new ArrayList<>());
        }

        int[] min = new int[n];
        Arrays.fill(min, Integer.MAX_VALUE);
        boolean[] visited = new boolean[n];

        int minCost = Integer.MAX_VALUE;
        int startIdx = 0;

        for (int[] cost : costs) {
            nodes.get(cost[0]).add(new Node(cost[1], cost[2]));
            nodes.get(cost[1]).add(new Node(cost[0], cost[2]));

            if (minCost > cost[2]) {
                minCost = cost[2];
                startIdx = cost[0];
            }
        }

        min[startIdx] = 0;
        dijkstra(startIdx, minCost, nodes, min, visited);

        int answer = 0;
        for (int cost : min) {
            answer += cost;
        }

        return answer;
    }

    private void dijkstra(int start, int costs, List<List<Node>> nodes, int[] min, boolean[] visited) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, costs));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (visited[now.to]) continue;

            visited[now.to] = true;

            for (Node next : nodes.get(now.to)) {
                if (!visited[next.to] && min[next.to] > next.cost) {
                    min[next.to] = next.cost;
                    pq.add(new Node(next.to, min[next.to]));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int to;
        int cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
