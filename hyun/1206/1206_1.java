import java.util.*;

class Solution {
    public List<Integer> solution(int[] arr, int[] delete_list) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int currentValue = arr[i];
            if (!Arrays.stream(delete_list).anyMatch(value -> value == currentValue)) {
                list.add(currentValue);
            }
        }
        return list;
    }
}