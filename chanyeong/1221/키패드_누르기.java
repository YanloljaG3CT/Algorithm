class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int[] left = {3, 0};
        int[] right = {3, 2};

        for (int number : numbers) {
            int y = number == 0 ? 3 : (number - 1) / 3;
            int x = number == 0 ? 1 : (number - 1) % 3;

            if (x == 0) {
                sb.append("L");
                left = new int[]{y, x};
            } else if (x == 2) {
                sb.append("R");
                right = new int[]{y, x};
            } else {
                int leftDistance = getDistance(left, y, x);
                int rightDistance = getDistance(right, y, x);

                if (leftDistance > rightDistance) {
                    sb.append("R");
                    right = new int[]{y, x};
                } else if (leftDistance < rightDistance) {
                    sb.append("L");
                    left = new int[]{y, x};
                } else {
                    if (hand.equals("right")) {
                        sb.append("R");
                        right = new int[]{y, x};
                    } else {
                        sb.append("L");
                        left = new int[]{y, x};
                    }
                }
            }
        }
        return sb.toString();
    }

    private int getDistance(int[] hand, int y, int x) {
        return Math.abs(hand[0] - y) + Math.abs(hand[1] - x);
    }
}
