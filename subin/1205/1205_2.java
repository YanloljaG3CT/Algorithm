import java.util.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        
        int[][] array = new int[rank.length][2];
        for (int i = 0; i < rank.length; i++) {
            array[i][0] = rank[i];
            array[i][1] = i;
        }
        
        Arrays.sort(array, (a, b) -> a[0] - b[0]);
        
        int[] students = new int[3];
        int index = 0;
        int count = 0;
        
        for (int i = 0; i < array.length; i++) {
            if (attendance[array[i][1]]) {
                students[index++] = array[i][1];
                count++;
            }
            if (count == 3) {
                break;
            }
        }
        
        int answer = 10000 * students[0] + 100 * students[1] + students[2];
        
        return answer;
    }
}
