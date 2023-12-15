import java.util.*;

class Solution {
    public int[] solution(String[] keymaps, String[] targets) {
        int len = targets.length;
        int[] answer = new int[len];

        Map<Character, Integer> key = new HashMap<>();
        for(String keymap : keymaps) {
            for(int i=0; i<keymap.length(); i++) {
                char ch = keymap.charAt(i);
                if(key.getOrDefault(ch, Integer.MAX_VALUE) > i) {
                    key.put(ch, i + 1);
                }
            }
        }

        for(int i=0; i<len; i++) {
            int sum = 0;
            for(char ch : targets[i].toCharArray()) {
                Integer count = key.get(ch);
                if(count == null) {
                    sum = -1;
                    break;
                }
                sum += count;
            }
            answer[i] = sum;
        }

        return answer;
    }
}
