#include <algorithm>
#include <iostream>
#include <vector>
using namespace std;

vector<pair<int, int>> v;

int result = 1;

int main() {
    int N;
    cin >> N;
    for (int i = 0; i < N; i++) {
        int start, end;
        cin >> start >> end;
        v.push_back(make_pair(end, start));
    }

    sort(v.begin(), v.end()); // 끝나는 시간 기준으로 정렬

    // for (int i = 0; i < v.size(); i++) {
    //     cout << v[i].first << " " << v[i].second << '\n';
    // }

    int time = v[0].first;

    for (int i = 1; i < v.size(); i++) {
        if (time <= v[i].second) {
            result++;
            time = v[i].first;
        }
    }

    cout << result;
}