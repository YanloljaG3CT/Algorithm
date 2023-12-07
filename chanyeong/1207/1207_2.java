import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        map.keySet().stream()
                .filter(c -> map.get(c) == 1)
                .sorted()
                .forEach(sb::append);
        return sb.toString();
    }
}
