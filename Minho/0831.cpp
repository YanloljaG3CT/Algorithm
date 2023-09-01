#include <algorithm>
#include <iostream>
#include <vector>
using namespace std;
vector<int> A;

int binarySearch(int num) {
    int left = 0;
    int right = A.size() - 1;

    while (left <= right) {
        int middle = (left + right) / 2;
        if (A[middle] == num)
            return 1;
        else if (A[middle] > num) {
            right = middle - 1;
        } else if (A[middle] < num) {
            left = middle + 1;
        }
    }

    return 0;
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int N;
    cin >> N;

    for (int i = 0; i < N; i++) {
        int num;
        cin >> num;
        A.push_back(num);
    }
    sort(A.begin(), A.end());

    int M;
    cin >> M;
    for (int i = 0; i < M; i++) {
        int num;
        cin >> num;
        cout << binarySearch(num) << '\n';
    }
}