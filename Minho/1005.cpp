#include <cstring>
#include <iostream>
#include <queue>
using namespace std;

int N;
int map[101][101];
bool visited[101][101] = {
    false,
};
int dy[4] = {1, -1, 0, 0};
int dx[4] = {0, 0, 1, -1};

bool inRange(int y, int x) {
    if (y >= 0 && x >= 0 && y < N && x < N)
        return true;

    return false;
}

void BFS(int y, int x, int rain) {
    visited[y][x] = true;
    queue<pair<int, int>> q;
    q.push({y, x});

    while (!q.empty()) {
        int cur_y = q.front().first;
        int cur_x = q.front().second;
        q.pop();

        for (int i = 0; i < 4; i++) {
            int next_y = cur_y + dy[i];
            int next_x = cur_x + dx[i];
            if (inRange(next_y, next_x) && map[next_y][next_x] > rain) {
                if (!visited[next_y][next_x]) {
                    visited[next_y][next_x] = true;
                    q.push({next_y, next_x});
                }
            }
        }
    }
}

int Solve(int rain) {
    int cnt = 0;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            if (!visited[i][j] && map[i][j] > rain) {
                cnt++;
                BFS(i, j, rain);
            }
        }
    }

    return cnt;
}

int main() {
    cin >> N;

    int min_num = 987654321;
    int max_num = 0;

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            cin >> map[i][j];
            min_num = min(min_num, map[i][j]);
            max_num = max(max_num, map[i][j]);
        }
    }

    int result = 1;

    for (int i = min_num; i <= max_num; i++) {
        result = max(result, Solve(i));
        memset(visited, false, sizeof(visited));
    }

    cout << result;
}