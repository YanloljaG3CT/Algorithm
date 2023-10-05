#include <iostream>
#include <queue>
using namespace std;

int N, M;
int map[101][101];
bool visited[101][101] = {
    false,
};
int dy[4] = {1, -1, 0, 0};
int dx[4] = {0, 0, 1, -1};

bool inRange(int y, int x) {
    if (y >= 0 && x >= 0 && y < N && x < M)
        return true;

    return false;
}

void BFS(int y, int x) {
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
            if (inRange(next_y, next_x) && !visited[next_y][next_x]) {
                if (map[next_y][next_x] == 1) {
                    visited[next_y][next_x] = true;
                    q.push({next_y, next_x});
                    map[next_y][next_x] = map[cur_y][cur_x] + 1;
                }
            }
        }
    }
}

int main() {
    cin >> N >> M;

    for (int i = 0; i < N; i++) {
        string temp;
        cin >> temp;

        for (int j = 0; j < temp.length(); j++) {
            map[i][j] = temp[j] - '0';
        }
    }

    BFS(0, 0);

    // for (int i = 0; i < N; i++) {
    //     for (int j = 0; j < M; j++) {
    //         cout << map[i][j] << " ";
    //     }
    //     cout << '\n';
    // }

    cout << map[N - 1][M - 1];

    return 0;
}