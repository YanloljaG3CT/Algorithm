import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets,((Comparator.comparingInt(o -> o[1]))));
        Stack<Integer> stack = new Stack<>();

        stack.push(targets[0][1]);
        for (int i = 1; i < targets.length; i++) {
            if (stack.peek() <= targets[i][0]) {
                stack.push(targets[i][1]);
            }
        }
        
        answer = stack.size();
        
        return answer;
    }
}
