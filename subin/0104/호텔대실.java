import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        List<Integer[]> times = new ArrayList<>();

        for (String[] strings : book_time) {
            times.add(new Integer[]{countMin(strings[0]), countMin(strings[1])});
        }
        times.sort((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(times.get(0)[1]);
        for (int i = 1; i < times.size(); i++) {
            if (pq.peek()+10 > times.get(i)[0]) {
                pq.add(times.get(i)[1]);
            } else {
                if(!pq.isEmpty()){
                    pq.poll();
                }
                pq.add(times.get(i)[1]);
            }
        }
        
        return pq.size();
    }
    
    public int countMin(String string) {
        return Integer.parseInt(string.substring(0, 2)) * 60 + Integer.parseInt(string.substring(3, 5));
    }
}
