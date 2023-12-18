class Solution {
    public String solution(String X, String Y) {
        int[] xCount = getCharCount(X);
        int[] yCount = getCharCount(Y);

        StringBuilder sb = new StringBuilder();
        for(int i=9; i>=0; i--) {
            int min = Math.min(xCount[i], yCount[i]);
            while(min > 0) {
                min--;
                sb.append(i);
            }
        }

        if(sb.length() == 0) {
            return "-1";
        }

        if(sb.toString().replaceAll("0", "").isEmpty()) {
            return "0";
        }

        return sb.toString();
    }

    private int[] getCharCount(String str) {
        int[] arr = new int[10];
        for(char c : str.toCharArray()) {
            arr[c - '0']++;
        }
        return arr;
    }
}
