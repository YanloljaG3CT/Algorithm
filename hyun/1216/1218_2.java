class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        int[] x = new int[10];
        int[] y = new int[10];

        char[] xrr = X.toCharArray();
        char[] yrr = Y.toCharArray();
        int length = (xrr.length > yrr.length) ? xrr.length : yrr.length;

        for (int i = 0; i < length; i++) {
            if (i < xrr.length) x[xrr[i] - '0']++;
            if (i < yrr.length) y[yrr[i] - '0']++;
        }

        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            while (true) {
                if (x[i] == 0 || y[i] == 0) break;
                arr[i]++;
                x[i]--;
                y[i]--;
            }
        }

        for (int i = 9; i >= 0; i--) {
            if (i == 0 && answer.toString().equals("") && arr[i] > 0) {
                return "0";
            }

            while (true) {
                if (arr[i] == 0) break;
                answer.append(String.valueOf(i));
                arr[i]--;
            }
        }

        if (answer.toString().equals("")) return "-1";

        return answer.toString();
    }
}