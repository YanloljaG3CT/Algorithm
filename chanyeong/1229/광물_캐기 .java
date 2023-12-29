class 과제_진행하기 {
    public int[] solution(int[] sequence, int k) {
        if (sequence[0] == k) {
            return new int[]{0, 0};
        }

        int[] answer = new int[]{0, Integer.MAX_VALUE};
        int left = 0;
        int right = 1;
        int sum = sequence[0];

        int len = sequence.length;
        while (right < len) {
            sum += sequence[right];

            while (sum > k) {
                sum -= sequence[left];
                left++;
            }

            if (sum == k) {
                if (right - left < answer[1] - answer[0]) {
                    answer[0] = left;
                    answer[1] = right;
                }
            }

            right++;
        }

        return answer;
    }
}
