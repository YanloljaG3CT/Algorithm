import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        Map<Integer, Boolean> lostMap = new HashMap<>();
        for(int num : lost) {
            lostMap.put(num, true);
        }

        List<Integer> reserveList = new ArrayList<>();
        for(int num : reserve) {
            if(lostMap.getOrDefault(num, false)) {
                lostMap.put(num, false);
                answer++;
                continue;
            }
            reserveList.add(num);
        }

        for(int num : reserveList) {
            if(lostMap.getOrDefault(num - 1, false)) {
                lostMap.put(num - 1, false);
                answer++;
                continue;
            }

            if(lostMap.getOrDefault(num + 1, false)) {
                lostMap.put(num + 1, false);
                answer++;
            }
        }

        return answer;
    }
}
