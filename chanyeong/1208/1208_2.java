import java.util.*;
import java.util.Map.Entry;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for(int i : array) {
            count.put(i, count.getOrDefault(i, 0) + 1);
        }

        int max = 0;
        for(Entry<Integer, Integer> entry : count.entrySet()) {
            if(max < entry.getValue()) {
                max = entry.getValue();
                answer = entry.getKey();
            } else if(max == entry.getValue()) {
                answer = -1;
            }
        }
        return answer;
    }
}
