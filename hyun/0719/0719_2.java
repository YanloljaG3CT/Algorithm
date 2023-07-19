import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        String[] todayInfo = today.split("\\.");
        int year = Integer.parseInt(todayInfo[0]);
        int month = Integer.parseInt(todayInfo[1]);
        int day = Integer.parseInt(todayInfo[2]);


        for (int i = 0; i < terms.length; i++) {
            String[] spl = terms[i].split(" ");
            map.put(spl[0], Integer.parseInt(spl[1]));
        }

        for (int i = 0; i < privacies.length; i++) {
            String[] spl = privacies[i].split(" ");
            int term = map.get(spl[1]);

            String[] rc = spl[0].split("\\.");
            int y = Integer.parseInt(rc[0]);
            int m = Integer.parseInt(rc[1]);
            int d = Integer.parseInt(rc[2]);

            if (term + m > 12) {
                y += (term + m) / 12;
                m = (term + m) % 12;
                if (m == 0) {
                    y--;
                    m = 12;
                }
            } else {
                m += term;
            }

            if (y < year) {
                list.add(i + 1);
            } else if (y == year) {
                if (m < month) {
                    list.add(i + 1);
                } else if (m == month) {
                    if (d <= day) {
                        list.add(i + 1);
                    }
                }
            }

        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}