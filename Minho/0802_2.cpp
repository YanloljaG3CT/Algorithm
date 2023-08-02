#include <iostream>
using namespace std;

int N, M;
int arr[10];
int result[10];

void DFS(int index, int cnt) {
    if (cnt == M) {
        for (int i = 1; i <= M; i++) {
            cout << result[i] << " ";
        }
        cout << '\n';
        return;
    }

    for (int i = index + 1; i <= N; i++) {
        result[cnt + 1] = i;
        DFS(i, cnt + 1);
    }
}

int main() {
    cin >> N >> M;
    for (int i = 1; i <= N; i++) {
        arr[i] = i;
    }

    for (int i = 1; i <= N; i++) {
        result[1] = i;
        DFS(i, 1);
    }
}