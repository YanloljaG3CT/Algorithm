import java.util.*;

class Solution {
    public String solution(String[] surveys, int[] choices) {
        String[][] types = {
                {"R", "T"},
                {"C", "F"},
                {"J", "M"},
                {"A", "N"}
        };

        int len = surveys.length;
        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<len; i++) {
            int score = Math.abs(choices[i] - 4);
            int choice = choices[i] / 4;
            String survey = surveys[i].split("")[choice];
            map.put(survey, map.getOrDefault(survey, 0) + score);
        }

        StringBuilder sb = new StringBuilder();
        for(String[] type : types) {
            if(map.getOrDefault(type[0], 0) < map.getOrDefault(type[1], 0)) {
                sb.append(type[1]);
                continue;
            }

            sb.append(type[0]);
        }

        return sb.toString();
    }
}
