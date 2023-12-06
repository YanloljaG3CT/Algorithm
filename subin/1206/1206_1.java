import java.util.*;

class Solution {
    public List<Integer> solution(int[] arr, int[] delete_list) {
        List<Integer> answer = new ArrayList<>();
        
        for (int n : arr){
            boolean delete = false;
            
            for (int m : delete_list) {
                if(n==m){
                    delete=true;
                    break;
                }
            }
            
            if(!delete){
                answer.add(n);
            }
        }
        
        return answer;
    }
}
