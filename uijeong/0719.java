// 1. 실패율

import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        double[] rate = new double[N];
        int chellenger = stages.length;
        int fail = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < stages.length; j++) {
                if ((stages[j] != 0) && (stages[j] <= i + 1)) {
                    // 다음 스테이지에서 검사하지 않도록 0으로 초기화
                    stages[j] = 0;
                    // 해당 스테이지 총 실패 횟수 증가
                    fail++;
                }
            }
            if (fail == 0 | chellenger == 0) {
                rate[i] = 0;
            } else {
                // 실패율 대입
                rate[i] = (double) fail / chellenger;
            }
            // 다음 스테이지 도달하지 못한 인원 제외
            chellenger -= fail;
            // 실패 횟수 초기화
            fail = 0;
        }

        // 스테이지 번호, 실패율 HashMap 생성
        Map<Integer, Double> stageMap = new HashMap<>();
        for (int i = 0; i < rate.length; i++) {
            stageMap.put(i + 1, rate[i]);
        }

        // 내림차순 정렬
        List<Integer> keySet = new ArrayList<>(stageMap.keySet());
        keySet.sort((o1, o2) -> stageMap.get(o2).compareTo(stageMap.get(o1)));

        // 정렬한 리스트 차례대로 배열에 대입
        for (int i = 0; i < keySet.size(); i++) {
            answer[i] = keySet.get(i);
        }

        return answer;
    }
}

// 2. 개인정보 수집 유효기간

import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        // result 초기화
        List<Integer> result = new ArrayList<>();

        // 약관 HashMap 생성
        Map<String, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            String[] splitTerm = term.split(" ");
            termMap.put(splitTerm[0], Integer.valueOf(splitTerm[1]));
        }

        // 개인정보 날짜, 약관 분리
        for (int i = 0; i < privacies.length; i++) {
            String[] splitPvc = privacies[i].split(" ");
            String date = splitPvc[0];
            String type = splitPvc[1];

            // 날짜 년*12*28 + 월*28 + 일로 모두 일수로 변환
            String[] splitPvcDate = date.split("\\.");
            int pvcYear = Integer.parseInt(splitPvcDate[0]);
            int pvcMonth = Integer.parseInt(splitPvcDate[1]);
            int pvcDay = Integer.parseInt(splitPvcDate[2]);
            int pvcDays = (pvcYear * 12 * 28) + (pvcMonth * 28) + pvcDay;

            // 파기 일수
            int expiryDate = termMap.get(type) * 28 + pvcDays;

            // 오늘 일수
            String[] splitDate = today.split("\\.");
            int year = Integer.parseInt(splitDate[0]);
            int month = Integer.parseInt(splitDate[1]);
            int day = Integer.parseInt(splitDate[2]);
            int days = (year * 12 * 28) + (month * 28) + day;

            // 파기 일수가 오늘 일수보다 적거나 같다면 리스트에 추가
            if (expiryDate <= days) {
                result.add(i + 1);
            }
        }

        // 반환할 배열에 대입
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}