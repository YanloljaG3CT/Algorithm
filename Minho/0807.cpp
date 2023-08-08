#include <iostream>
using namespace std;

int map[5][5];
int numbers[5][5];
int bingo = 0;

void Debugg() {
    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
            cout << map[i][j] << " ";
        }
        cout << '\n';
    }
    cout << '\n';
}

void Check(int number) {
    int y, x;
    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
            if (map[i][j] == number) {
                y = i;
                x = j;
            }
        }
    }

    map[y][x] = -1;

    bool flag = true;

    // 가로
    for (int i = 0; i < 5; i++) {
        if (map[i][x] != -1) {
            flag = false;
            break;
        }
    }

    if (flag) {
        bingo++;
    }
    flag = true;
    // 세로
    for (int i = 0; i < 5; i++) {
        if (map[y][i] != -1) {
            flag = false;
            break;
        }
    }

    if (flag) {
        bingo++;
    }
    flag = true;
    // 대각선
    for (int i = 0; i < 5; i++) {
        if (map[i][i] != -1) {
            flag = false;
            break;
        }
    }

    if (flag) {
        bingo++;
    }
    flag = true;
    int cnt = 0;
    for (int i = 4; i >= 0; i--) {
        if (map[i][cnt] != -1) {
            flag = false;
            break;
        }
        cnt++;
    }

    if (flag) {
        bingo++;
    }
}

int main() {
    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
            cin >> map[i][j];
        }
    }

    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
            cin >> numbers[i][j];
        }
    }
    int result = 0;
    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
            int temp = numbers[i][j];
            result++;
            Check(temp);
            if (bingo >= 3) {
                cout << result;
                return 0;
            }

            // Debugg();
        }
    }

    return 0;
}