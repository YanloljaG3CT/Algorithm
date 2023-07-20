import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = {};
        
        HashMap<Integer,Double> failureMap = new HashMap<>();
        int[] stopPlayers = new int[N+2]; //스테이지별 도전 중인 플레이어 수
        int[] reachedPlayers = new int[N+1]; //스테이지별 도달한 플레이어 수(클리어 한 사람+도전중인 사람)
        
        for(int stage:stages){
            stopPlayers[stage]++;
        }
        
        reachedPlayers[N]=stopPlayers[N]+stopPlayers[N+1];
        for(int i=N-1;i>0;i--){
            reachedPlayers[i]=stopPlayers[i]+reachedPlayers[i+1];
        }
        
        //실패율 계산
        for(int i=1;i<reachedPlayers.length;i++){
            if(reachedPlayers[i]==0){
                failureMap.put(i,0.0);
            }else{
                failureMap.put(i,(double)stopPlayers[i]/reachedPlayers[i]);
            }
        }
        
        List<Integer> list = new ArrayList<>(failureMap.keySet());
        Collections.sort(list,(n1,n2) -> Double.compare(failureMap.get(n2),failureMap.get(n1)));//내림차순 정렬
        
        answer=list.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}
