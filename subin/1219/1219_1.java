package fc1219;

import java.util.HashMap;
import java.util.Map;

public class pg118666 {
    public static void main(String[] args) {
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choice = {5, 3, 2, 7, 5};

        int[] num = {3, 2, 1, 0, 1, 2, 3};

        StringBuilder sb = new StringBuilder();

        Map<Character, Integer> map = new HashMap<>();
        for (String s : survey) {
            map.put(s.charAt(0), 0);
            map.put(s.charAt(1), 0);
        }
        for (int i = 0; i < survey.length; i++) {
            if (choice[i] < 4) {
                map.put(survey[i].charAt(0), map.get(survey[i].charAt(0)) + num[choice[i] - 1]);
            }
            if (choice[i] > 4) {
                map.put(survey[i].charAt(1), map.get(survey[i].charAt(1)) + num[choice[i] - 1]);
            }
        }

        if (map.getOrDefault('R',0) >= map.getOrDefault('T',0)) {
            sb.append('R');
        } else {
            sb.append('T');
        }

        if (map.getOrDefault('C',0) >= map.getOrDefault('F',0)) {
            sb.append('C');
        } else {
            sb.append('T');
        }

        if (map.getOrDefault('J',0) >= map.getOrDefault('M',0)) {
            sb.append('J');
        } else {
            sb.append('M');
        }
        if (map.getOrDefault('A',0) >= map.getOrDefault('N',0)) {
            sb.append('A');
        } else {
            sb.append('N');
        }

    }
}
