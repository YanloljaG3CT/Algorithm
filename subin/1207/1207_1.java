import java.util.*;

class Solution {
    public List<String> solution(String[] quiz) {
        
        List<String> answer = new ArrayList<>();

        for (String s : quiz) {
            String[] s1 = s.split(" ");
            if(s1[1].equals("+")){
                if(Integer.parseInt(s1[0])+Integer.parseInt(s1[2])==Integer.parseInt(s1[4])){
                    answer.add("O");
                }else {
                    answer.add("X");
                }
            }
            
            
            if(s1[1].equals("-")){
                if(Integer.parseInt(s1[0])-Integer.parseInt(s1[2])==Integer.parseInt(s1[4])){
                    answer.add("O");
                }else {
                    answer.add("X");
                }
            }
        }
        return answer;
    }
}
