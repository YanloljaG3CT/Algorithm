import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();

        //<선수, 랭크> 저장
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }

        for (String calling : callings) {
            int rank = map.get(calling);

            String prePlayer = players[rank - 1];
            players[rank-1] = calling;
            players[rank] = prePlayer;
            map.replace(calling,rank-1);
            map.replace(prePlayer, rank);
        }
        
        return players;
    }
}
