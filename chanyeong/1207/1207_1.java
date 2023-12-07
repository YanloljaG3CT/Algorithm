import java.util.*;

class Solution {
    public String[] solution(String[] quiz) {
        int len = quiz.length;
        String[] answer = new String[len];

        for(int i=0; i<len; i++) {
            String[] split = quiz[i].split("=");
            int left = calculate(split[0]);
            int right = Integer.parseInt(split[1].trim());
            answer[i] = (left == right) ? "O" : "X";
        }
        return answer;
    }

    private int calculate(String formula) {
        String[] sources = formula.split(" ");

        switch (sources[1]) {
            case "+" :
                return Integer.parseInt(sources[0]) + Integer.parseInt(sources[2]);
            case "-" :
                return Integer.parseInt(sources[0]) - Integer.parseInt(sources[2]);
            default :
                throw new RuntimeException();
        }
    }
}
