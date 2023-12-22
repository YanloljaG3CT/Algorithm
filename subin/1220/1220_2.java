import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
        answer = new int[id_list.length];
        HashMap<String, HashSet<String>> reportInfo = new HashMap<>(); //유저별 자신을 신고한 유저
        HashMap<String, Integer> idMap = new HashMap<>(); //유저들 각각의 순서
        
        for(int i=0;i<id_list.length;i++){
            reportInfo.put(id_list[i],new HashSet<>());
            idMap.put(id_list[i],i);
        }
        
        for(String id:report){
            String reportId = id.split(" ")[0];
            String reportedId = id.split(" ")[1];
            reportInfo.get(reportedId).add(reportId);
        }
        
        for(int i=0; i<id_list.length;i++){
            HashSet<String> reportSet = reportInfo.get(id_list[i]);
            if(reportSet.size()>=k){
                for(String user : reportSet){
                    answer[idMap.get(user)]++;
                }
            }
        }
        return answer;
    }
}
