import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<Character, Integer> map = new HashMap<>();

        for (char c = 'A'; c <= 'Z'; c++) {
            map.put(c, Integer.MAX_VALUE);
        }

        for (String s : keymap) {
            char[] arr = s.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                map.put(arr[i], Math.min(map.get(arr[i]), i + 1));
            }
        }

        for (int i = 0; i < targets.length; i++) {
            for (char c : targets[i].toCharArray()) {
                if (map.get(c) > 100) {
                    answer[i] = -1;
                    break;
                }
                answer[i] += map.get(c);
            }
        }

        return answer;
    }
}