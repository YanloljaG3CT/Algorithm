package fc1220;

import java.util.HashMap;
import java.util.Map;

//없는 숫자 더하기
public class pg86051 {
    public static void main(String[] args) {
        int[] numbers = {5, 8, 4, 0, 6, 7, 9};

        int answer = 0;

        Map<Integer, Integer> nums = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            nums.put(i, 0);
        }

        for (int number : numbers) {
            nums.put(number, 1);
        }

        for (Integer i : nums.keySet()) {
            if(nums.get(i)==0){
                answer += i;
            }
        }
        System.out.println(answer);
    }
}
