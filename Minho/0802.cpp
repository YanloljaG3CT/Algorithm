#include <iostream>
using namespace std;

int N, M;
int arr[10];
bool visited[10];

void Backtracking(int cnt) {
    if (cnt == M) {
        for (int i = 0; i < M; i++) {
            cout << arr[i] << " ";
        }
        cout << '\n';
        return;
    }

    for (int i = 1; i <= N; i++) {
        if (!visited[i]) {
            arr[cnt] = i;
            visited[i] = true;
            Backtracking(cnt + 1);
            visited[i] = false;
        }
    }
}

int main() {

    cin >> N >> M;

    Backtracking(0);
}