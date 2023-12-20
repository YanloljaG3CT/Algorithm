import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Map<String, Set<String>> map = new HashMap<>();
        Map<String, Integer> nameIdx = new HashMap<>();
        int i = 0;
        for (String name : id_list) {
            nameIdx.put(name, i++);
            map.put(name, new HashSet<>());
        }

        for (String contents : report) {
            String[] content = contents.split(" ");
            String reporter = content[0];
            String target = content[1];

            map.get(target).add(reporter);
        }

        for (String name : id_list) {
            if (map.get(name).size() >= k) {
                for (String mailTarget : map.get(name)) {
                    int idx = nameIdx.get(mailTarget);
                    answer[idx]++;
                }
            }
        }

        return answer;
    }
}
