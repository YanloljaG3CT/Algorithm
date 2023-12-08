import java.util.*;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        int[] arr = new int[1000];
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            arr[array[i]]++;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > count) {
                answer = i;
                count = arr[i];
            }
        }
        Arrays.sort(arr);
        if (arr[999] == arr[998]) {
            answer = -1;
        }
        return answer;
    }
}