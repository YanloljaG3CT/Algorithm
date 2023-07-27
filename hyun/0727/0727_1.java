import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int[] island = new int[n];

        // 처음 대표(부모)는 자기 자신
        for (int i = 0; i < n; i++) {
            island[i] = i;
        }

        // 건설비용 오름차순 정렬
        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));

        for (int i = 0; i < costs.length; i++) {
            // find - 두 섬의 대표가 다르면
            if (find(island, costs[i][0]) != find(island, costs[i][1])) {
                // union - 연결
                unite(island, costs[i][0], costs[i][1]);
                answer += costs[i][2];
            }
        }
        return answer;
    }
    private int find (int[] island, int x) {
        if (island[x] == x) {
            return x;
        }
        return find(island, island[x]);
    }

    private void unite (int[] island, int x, int y) {
        int a = find(island, x);
        int b = find(island, y);
        island[a] = b; // a의 대표 b로 변경
    }
}