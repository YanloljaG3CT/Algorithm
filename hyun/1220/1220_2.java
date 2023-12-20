import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        int answer = 0;
        for (int i : numbers) {
            set.add(i);
        }
        for (int n = 0; n <= 9; n++) {
            if (set.contains(n)) continue;
            answer += n;
        }
        return answer;
    }
}