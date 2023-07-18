import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int len = id_list.length;
        int[] answer = new int[len];

        Map<String, Integer> nameIdx = new HashMap<>();
        Map<String, Set<String>> reportMap = new HashMap<>();

        for (int i = 0; i < len; i++) {
            nameIdx.put(id_list[i], i);
            reportMap.put(id_list[i], new HashSet<>());
        }

        for (String contents : report) {
            String[] content = contents.split(" ");
            String reporter = content[0];
            String target = content[1];

            reportMap.get(target).add(reporter);
        }

        for (String name : id_list) {
            if (reportMap.get(name).size() < k) continue;

            for (String mailTarget : reportMap.get(name)) {
                int idx = nameIdx.get(mailTarget);
                answer[idx]++;
            }
        }

        return answer;
    }
}
