#include <algorithm>
#include <string>
#include <vector>

using namespace std;

int parent[102];

bool cmp(vector<int> a, vector<int> b) { return a[2] < b[2]; }

int findParent(int index) {
    if (parent[index] == index)
        return index;

    return parent[index] = findParent(parent[index]);
}

int solution(int n, vector<vector<int>> costs) {
    int answer = 0;

    sort(costs.begin(), costs.end(), cmp); // 비용을 기준으로 정렬

    for (int i = 0; i < n; i++) {
        parent[i] = i;
    }

    for (int i = 0; i < costs.size(); i++) {
        int start = findParent(costs[i][0]);
        int end = findParent(costs[i][1]);
        int cost = costs[i][2];

        if (start != end) {
            answer += cost;
            parent[end] = start;
        }
    }

    return answer;
}