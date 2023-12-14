class Solution {
    public int solution(int n, int m, int[] section) {
        int paint = 1;
        int count = 0;

        for (int point : section) {
            if (paint <= point) {
                paint = m + point;
                count++;
            }
        }

        return count;
    }
}