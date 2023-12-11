import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        int len = players.length;
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i <len; i++) {
            map.put(players[i], i);
        }

        for(String calling : callings) {
            int index = map.get(calling);
            String prevPlayer = changeLocation(players, index);

            map.put(calling, map.get(calling) - 1);
            map.put(prevPlayer, map.get(prevPlayer) + 1);
        }
        return players;
    }

    private String changeLocation(String[] players, int index) {
        String prevPlayer = players[index - 1];
        players[index - 1] = players[index];
        players[index] = prevPlayer;
        return prevPlayer;
    }
}
