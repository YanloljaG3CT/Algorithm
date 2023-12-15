import java.util.*;

class Solution {
    static int[] hamburger = {1, 3, 2, 1};

    public int solution(int[] ingredients) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int ingredient : ingredients) {
            stack.push(ingredient);

            if(stack.size() >= hamburger.length) {
                boolean flag = true;
                while(flag && stack.size() >= hamburger.length) {
                    flag = isHamburger(stack);
                    if(flag) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

    private boolean isHamburger(Stack<Integer> stack) {
        Stack<Integer> tmp = new Stack<>();
        for(int ingredient : hamburger) {
            if(ingredient != stack.peek()) {
                while(!tmp.isEmpty()) {
                    stack.push(tmp.pop());
                }
                return false;
            }
            tmp.push(stack.pop());
        }
        return true;
    }
}
