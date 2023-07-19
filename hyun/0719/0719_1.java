import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Map<Integer, Double> failRates = new HashMap<>();
        int totalUsers = stages.length;

        for (int stage = 1; stage <= N; stage++) {
            int failedUsers = 0;
            for (int j = 0; j < stages.length; j++) {
                if (stages[j] == stage) {
                    failedUsers++;
                }
            }

            double failRate = (totalUsers == 0) ? 0 : (double) failedUsers / totalUsers;
            failRates.put(stage, failRate);
            totalUsers -= failedUsers;
        }

        List<Map.Entry<Integer, Double>> list = new LinkedList<>(failRates.entrySet());
        list.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i).getKey();
        }

        return answer;
    }
}