import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 45;
        boolean[] v = new boolean[10];

        for (int i : numbers) {
            if (!v[i]) answer -= i;
            else v[i] = true;
        }

        return answer;
    }
}