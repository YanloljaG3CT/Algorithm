import java.util.*;

class Solution {
    public int[] solution(String myString) {
        int[] answer = {};
        List<Integer> answerList = new ArrayList<>();
        
        String[] strs = myString.split("x");
        
        for(String str:strs){
            answerList.add(str.length());    
        }
        
        if(myString.charAt(myString.length()-1)=='x'){
            answerList.add(0);
        }
        
        answer = new int[answerList.size()];
        for(int i =0;i<answerList.size();i++){
            answer[i]=answerList.get(i).intValue();
        }
        return answer;
        
        // return answerList.stream()
        //         .mapToInt(Integer::intValue)
        //         .toArray();
        
    }
}
