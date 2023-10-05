#include <algorithm>
#include <iostream>
using namespace std;

int main() {
    int N;                   // 물이 새는 곳의 개수
    int L;                   // 테이프의 길이
    int leak_location[1000]; // 물이 새는 곳의 위치
    int start;               // 각 테이프의 시작 위치
    int tape = 0;            // 필요한 테이프의 개수

    cin >> N >> L;

    for (int i = 0; i < N; i++) {
        cin >> leak_location[i];
    }

    // 물이 새는 위치를 오름차순 정렬
    sort(leak_location, leak_location + N);

    // 시작 위치를 맨 처음 누수 위치로 설정
    start = leak_location[0];

    for (int i = 1; i < N; i++) {
        // 테이프의 길이가 모자라게 되면
        if (L <= leak_location[i] - start) { // 테이프의 길이 <= 시작 지점부터 다른 누수 지점(A) 까지의 거리) 가 되면, 필요한 테이프의 개수 + 1
            // 해당 지점 전까지 테이프를 사용했으므로 값 증가
            tape++;
            // 테이프가 부족한 지점부터 시작위치 재설정
            start = leak_location[i];
        }
    }

    // for문에서 마지막에 붙인 테이프는 세지 않았으므로 + 1
    cout << tape + 1;

    return 0;
}
