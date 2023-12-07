import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : map.keySet()) {
            if (map.get(c) == 1) {
                answer += c;
            }
        }
        char[] answerArr = answer.toCharArray();
        Arrays.sort(answerArr);
        answer = new String(answerArr);
        return answer;
    }
}