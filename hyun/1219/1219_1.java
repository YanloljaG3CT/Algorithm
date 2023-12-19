class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();

        int r = 0, t = 0, c = 0, f = 0, j = 0, m = 0, a = 0, n = 0;
        for (int i = 0; i < choices.length; i++) {
            char ch = Character.toLowerCase(survey[i].charAt(0));
            if (ch == 'r') r += point(choices[i]);
            if (ch == 't') t += point(choices[i]);
            if (ch == 'c') c += point(choices[i]);
            if (ch == 'f') f += point(choices[i]);
            if (ch == 'j') j += point(choices[i]);
            if (ch == 'm') m += point(choices[i]);
            if (ch == 'a') a += point(choices[i]);
            if (ch == 'n') n += point(choices[i]);
        }

        String rt = (r < t) ? "T" : "R";
        String cf = (c < f) ? "F" : "C";
        String jm = (j < m) ? "M" : "J";
        String an = (a < n) ? "N" : "A";
        answer.append(rt).append(cf).append(jm).append(an);

        return answer.toString();
    }

    public int point(int n) {
        if (n == 1) return 3;
        if (n == 2) return 2;
        if (n == 3) return 1;
        if (n == 4) return 0;
        if (n == 5) return -1;
        if (n == 6) return -2;
        if (n == 7) return -3;
        return 0;
    }
}