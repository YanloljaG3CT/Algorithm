package fc1214;

//덧칠하기
public class pg161989 {
    public static void main(String[] args) {
        int n = 8, m = 4;
        int[] section = {2, 3, 6};

        int answer = 1;
        int start = section[0];
        int end = section[0] + m - 1;

        for (int i : section) {
            if (i >= start && i <= end) {
                continue;
            }
            else {
                start = i;
                end = i + m - 1;
                answer++;
            }
        }
        System.out.println(answer);

    }
}
