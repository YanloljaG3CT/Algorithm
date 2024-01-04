import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 1;
        List<Hotel> list = new ArrayList<>();
        for(String[] times : book_time) {
            list.add(new Hotel(times));
        }
        Collections.sort(list);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(Hotel hotel : list) {
            if(pq.isEmpty()) {
                pq.offer(hotel.end);
                continue;
            }

            while(!pq.isEmpty() && hotel.start >= pq.peek() + 10) {
                pq.poll();
            }

            pq.offer(hotel.end);
            answer = Math.max(answer, pq.size());
        }

        return answer;
    }

    static class Hotel implements Comparable<Hotel> {
        int start;
        int end;

        public Hotel(String[] times) {
            this.start = getMinute(times[0]);
            this.end = getMinute(times[1]);
        }

        private int getMinute(String time) {
            String[] split = time.split(":");
            int hour = Integer.parseInt(split[0]);
            int minute = Integer.parseInt(split[1]);
            return (hour * 60) + minute;
        }

        @Override
        public int compareTo(Hotel o) {
            if(start == o.start) {
                return end - o.end;
            }
            return start - o.start;
        }
    }
}
