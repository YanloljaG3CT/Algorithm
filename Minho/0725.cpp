#include <iostream>
#include <vector>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, l;
    cin >> n >> l;

    vector<int> input(n);
    for (int i = 0; i < n; ++i) {
        cin >> input[i];
    }

    vector<double> pSum(n);
    pSum[0] = input[0];

    for (int i = 1; i < n; ++i) {
        pSum[i] = pSum[i - 1] + input[i];
    }

    for (int i = 0; i < n - 1; ++i) {
        if ((pSum[n - 1] - pSum[i]) / (n - 1 - i) <= input[i] - l || (pSum[n - 1] - pSum[i]) / (n - 1 - i) >= input[i] + l) {
            cout << "unstable";
            return 0;
        }
    }

    cout << "stable";

    return 0;
}
