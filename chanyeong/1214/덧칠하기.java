class Solution {
    public int solution(int n, int m, int[] sections) {
        int answer = 0;

        int location = Integer.MIN_VALUE;
        for(int section : sections) {
            if(section > location) {
                location = section + m - 1;
                answer++;
            }
        }

        return answer;
    }
}
