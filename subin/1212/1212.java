import java.util.*;

//추억 점수
class Solution {
    public List<Integer> solution(String[] name, int[] yearning, String[][] photo) {
        
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }

        List<Integer> answer = new ArrayList<>();

        for (String[] p : photo) {
            int count=0;
            for (int i = 0; i < p.length; i++) {
                count += map.getOrDefault(p[i],0);
            }
            answer.add(count);
        }
        
        return answer;
    }
}
