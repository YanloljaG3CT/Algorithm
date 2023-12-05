import java.util.*;

class Solution {
    public int[] solution(String myString) {
        ArrayList<Integer> list = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < myString.length(); i++) {
            if (myString.charAt(i) == 'x') {
                list.add(count);
                count = 0;
                if (i == myString.length() - 1) {
                    list.add(count);
                }
            } else if (i == myString.length() - 1) {
                list.add(++count);
            } else {
                count++;
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}