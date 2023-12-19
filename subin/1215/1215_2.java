package fc1215;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//대충 만든 자판
public class pg160586 {
    public static void main(String[] args) {
        String[] keymap = {"BC"};
        String[] targets = {"AC", "BC"};

        List<Integer> answers = new ArrayList<>();
        int maxValue = Integer.MAX_VALUE;

        Map<Character, Integer> keys = new HashMap<>();
        for (String s : keymap) {
            for (int i = 0; i < s.length(); i++) {
                int num = Math.min(keys.getOrDefault(s.charAt(i), maxValue), i + 1);
                keys.put(s.charAt(i), num);
            }
        }
        for (String target : targets) {
            int answer = 0;
            for (int i = 0; i < target.length(); i++) {
                if (keys.containsKey(target.charAt(i))) {
                    answer += keys.get(target.charAt(i));
                } else {
                    answer = -1;
                    break;
                }
            }
            answers.add(answer);
        }

        for (int i = 0; i < answers.size(); i++) {
            System.out.println(answers.get(i));
        }

    }
}
