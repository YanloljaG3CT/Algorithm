#include <algorithm>
#include <iostream>
using namespace std;

int main() {
    int N, M;
    cin >> N >> M;
    int blue_ray[100001];

    long long sum = 0;
    long long left = -1;

    for (int i = 0; i < N; i++) {
        cin >> blue_ray[i];
        sum += blue_ray[i];
        if (left < blue_ray[i])
            left = blue_ray[i];
    }

    long long right = sum;

    while (left <= right) {
        long long cnt = 0;
        long long middle = (left + right) / 2;
        long long temp_sum = 0;

        for (int i = 0; i < N; i++) {
            if (temp_sum + blue_ray[i] > middle) {
                temp_sum = 0;
                cnt++;
            }
            temp_sum += blue_ray[i];
        }

        if (temp_sum != 0)
            cnt++;

        if (cnt <= M)
            right = middle - 1;
        else
            left = middle + 1;
    }

    cout << left;
}