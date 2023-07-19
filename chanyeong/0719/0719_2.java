import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    DateTimeFormatter dateFormat;

    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        dateFormat = DateTimeFormatter.ofPattern("yyyy.MM.dd");

        LocalDate date = LocalDate.parse(today, dateFormat);

        // today 로 부터 유효기간 이전의 날 저장
        Map<String, String> termSheet = new HashMap<>();
        for (String term : terms) {
            String[] split = term.split(" ");
            termSheet.put(split[0], getMinusDate(date, split[1]));
        }

        // 유효기간 이전의 날에 수집된 개인정보는 파기
        for (int i = 0; i < privacies.length; i++) {
            String[] split = privacies[i].split(" ");
            if (termSheet.get(split[1]).compareTo(split[0]) >= 0) {
                answer.add(i + 1);
            }
        }

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private String getMinusDate(LocalDate date, String minusMonth) {
        return date.minusMonths(Integer.parseInt(minusMonth)).format(dateFormat);
    }
}