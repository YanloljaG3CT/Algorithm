package fc1221;

//키패드 누르기
public class pg67256 {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";

        StringBuilder answer = new StringBuilder();
        int left = 0;
        int right = 0;

        for (int number : numbers) {
            if (number == 1 || number == 4 || number == 7) {
                answer.append("L");
            }

            if (number == 3 || number == 6 || number == 9) {
                answer.append("L");
            }
        }
    }
}
