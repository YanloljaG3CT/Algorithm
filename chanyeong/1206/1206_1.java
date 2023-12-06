import java.util.*;

class Solution {
    public List<Integer> solution(int[] arr, int[] delete_list) {
        List<Integer> answer = new ArrayList<>();
        for(int num : arr) {
            if(!isExist(delete_list, num)) {
                answer.add(num);
            }
        }
        return answer;
    }

    private boolean isExist(int[] delete, int target) {
        for(int num : delete) {
            if(num == target) {
                return true;
            }
        }
        return false;
    }
}
