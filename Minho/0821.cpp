#include <iostream>
#include <vector>
using namespace std;
int N, answer;
vector<string> map(53);

void eat() {
    for (int i = 0; i < N; i++) {
        int sum = 1;
        for (int j = 0; j < N - 1; j++) {
            if (map[i][j] == map[i][j + 1]) {
                sum++;
            } else {
                answer = max(answer, sum);
                sum = 1;
            }
        }
        answer = max(answer, sum);
    }

    for (int i = 0; i < N; i++) {
        int sum = 1;
        for (int j = 0; j < N - 1; j++) {
            if (map[j][i] == map[j + 1][i]) {
                sum++;
            } else {
                answer = max(answer, sum);
                sum = 1;
            }
        }
        answer = max(answer, sum);
    }
}

int main() {
    cin >> N;

    for (int i = 0; i < N; i++) {
        cin >> map[i];
    }

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N - 1; j++) {
            if (map[i][j] != map[i][j + 1]) {
                swap(map[i][j], map[i][j + 1]);
                eat();
                swap(map[i][j], map[i][j + 1]);
            }

            if (map[j][i] != map[j + 1][i]) {
                swap(map[j][i], map[j + 1][i]);
                eat();
                swap(map[j][i], map[j + 1][i]);
            }
        }
    }

    cout << answer;
}