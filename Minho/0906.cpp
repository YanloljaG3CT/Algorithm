#include <algorithm>
#include <iostream>
#include <vector>
using namespace std;

int main() {
    int n;
    long long dist[100001]; // i번 도시에서 i-1번 도시까지의 거리 : dist[i]
    long long price[100001];
    long long min_price[100001]; // 1 ~ (i-1) 번 도시중 가장 싼 주유소 가격 : min_price[i]

    cin >> n;
    for (int i = 0; i < n - 1; i++) {
        cin >> dist[i];
    }

    for (int i = 0; i < n; i++) {
        cin >> price[i];
    }

    min_price[0] = price[0];
    for (int i = 1; i < n; i++) {
        min_price[i] = min(price[i], min_price[i - 1]);
    }

    // 가장 싼 곳에서 넣고 온다
    long long answer = 0;
    for (int i = 0; i < n - 1; i++) {
        answer += dist[i] * min_price[i];
    }

    cout << answer;
    return 0;
}