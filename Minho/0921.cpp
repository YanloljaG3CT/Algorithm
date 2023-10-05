#include <algorithm>
#include <iostream>
using namespace std;
int N;
int A[1002];
int dp[1002];

int main() {
    cin >> N;
    for (int i = 0; i < N; i++) {
        cin >> A[i];
        dp[i] = 1;
    }

    int result = 0;

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < i; j++) {
            if (A[i] > A[j]) {
                dp[i] = max(dp[j] + 1, dp[i]);
            }
        }
        result = max(result, dp[i]);
    }

    cout << result;

    return 0;
}