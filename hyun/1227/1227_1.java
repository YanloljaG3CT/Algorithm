class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int sum = 0, n = 0;
        int left = 0;
        int right = sequence.length;

        for (int i = 0; i < sequence.length; i++) {
            while (n < sequence.length && sum < k) {
                sum += sequence[n++];
            }

            if (sum == k) {
                int r = n - i - 1;
                if ((right - left) > r) {
                    left = i;
                    right = n - 1;
                }
            }

            sum -= sequence[i];
        }

        answer[0] = left;
        answer[1] = right;

        return answer;
    }
}