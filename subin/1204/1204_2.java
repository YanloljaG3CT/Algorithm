import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        String[] answer = {};
        List<String> answerList = new ArrayList<>();
        
        answer = my_string.split(" ");
        for(String str : answer){
            if(!str.isBlank()){
                answerList.add(str);        
            }
        }
        
        return answerList.toArray(new String[0]);
    }
}
