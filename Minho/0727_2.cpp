#include <string>
#include <vector>

using namespace std;

int solution(vector<vector<int>> board, vector<vector<int>> skill) {
    int answer = 0;

    for (int i = 0; i < skill.size(); i++) {
        int type = skill[i][0];
        int y_start = skill[i][1];
        int x_start = skill[i][2];
        int y_end = skill[i][3];
        int x_end = skill[i][4];
        int amount = skill[i][5];

        for (int i = y_start; i <= y_end; i++) {
            for (int j = x_start; j <= x_end; j++) {
                if (type == 1)
                    board[i][j] -= amount;
                else if (type == 2)
                    board[i][j] += amount;
            }
        }

        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board[0].size(); j++) {
                if (board[i][j] > 0)
                    answer++;
            }
        }
    }
    return answer;
}

// skill의 열의 길이 = 6
// skill의 각 행은 [type, r1, c1, r2, c2, degree]형태를 가지고 있습니다.
// type은 1 혹은 2입니다.
// type이 1일 경우는 적의 공격을 의미합니다. 건물의 내구도를 낮춥니다.
// type이 2일 경우는 아군의 회복 스킬을 의미합니다. 건물의 내구도를 높입니다.

// 1 ≤ board의 행의 길이 (= N) ≤ 1,000
// 1 ≤ board의 열의 길이 (= M) ≤ 1,000
// 1 ≤ board의 원소 (각 건물의 내구도) ≤ 1,000
// 1 ≤ skill의 행의 길이 ≤ 250,000

// 최악의 경우 1000 * 1000 * 250000 이 되기 때문에 이 방법으로는 풀 수 없다

#include <string>
#include <vector>

using namespace std;

int solution(vector<vector<int>> board, vector<vector<int>> skill) {
    int answer = 0;
    int map[1001][1001];

    for (int i = 0; i < skill.size(); i++) {
        int type = skill[i][0];
        int y_start = skill[i][1];
        int x_start = skill[i][2];
        int y_end = skill[i][3];
        int x_end = skill[i][4];
        int amount = skill[i][5];

        if (type == 1)
            amount *= -1;

        map[y_start][x_start] += amount;
        map[y_start][x_end + 1] -= amount;
        map[y_end + 1][x_start] -= amount;
        map[y_end + 1][x_end + 1] += amount;
    }

    for (int i = 1; i < board.size(); i++) {
        for (int j = 0; j < board[0].size(); j++) {
            map[i][j] += map[i - 1][j];
        }
    }

    for (int i = 0; i < board.size(); i++) {
        for (int j = 1; j < board[0].size(); j++) {
            map[i][j] += map[i][j - 1];
        }
    }

    for (int i = 1; i < board.size(); i++) {
        for (int j = 0; j < board[0].size(); j++) {
            if (map[i][j] + board[i][j] > 0)
                answer++;
        }
    }
    return answer;
}
