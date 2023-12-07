class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];

        for (int i = 0; i < quiz.length; i++) {
            String[] tokens = quiz[i].split(" ");

            if (tokens[1].equals("-")) {
                if (Integer.parseInt(tokens[0]) - Integer.parseInt(tokens[2]) == Integer.parseInt(tokens[4])) {
                    answer[i] = "O";
                } else {
                    answer[i] = "X";
                }
            } else {
                if (Integer.parseInt(tokens[0]) + Integer.parseInt(tokens[2]) == Integer.parseInt(tokens[4])) {
                    answer[i] = "O";
                } else {
                    answer[i] = "X";
                }
            }
        }
        return answer;
    }
}