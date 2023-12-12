import java.util.*;

class Solution {
    public int[] solution(String[] names, int[] yearning, String[][] photos) {
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<names.length; i++) {
            map.put(names[i], yearning[i]);
        }

        return Arrays.stream(photos)
                .mapToInt(photo -> Arrays.stream(photo)
                        .mapToInt(name -> map.getOrDefault(name, 0))
                        .sum())
                .toArray();
    }
}
