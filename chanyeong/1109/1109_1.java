import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        input();
        solution();
    }

    static int N;
    static Lecture[] lectures;

    static void input() {
        ScannerReader sr = new ScannerReader();
        N = sr.nextInt();

        lectures = new Lecture[N];
        for (int i = 0; i < N; i++) {
            int start = sr.nextInt();
            int end = sr.nextInt();
            lectures[i] = new Lecture(start, end);
        }
    }

    static void solution() {
        // 강의 시작 시간이 빠른 순으로, 시작 시간이 같다면 빨리 끝나는 순으로 정렬
        Arrays.sort(lectures);

        // 가장 빨리 끝나는 강의부터 순차적으로 확인하기 위해 우선순위 큐 선언
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // 최소 한 개 이상의 강의를 진행하기 때문에 1로 초기화
        int max = 1;
        for (int i = 0; i < N; i++) {
            // 배정된 강의가 없다면 반드시 배정
            if (pq.isEmpty()) {
                pq.offer(lectures[i].end);
                continue;
            }

            // 이미 끝난 강의가 있다면, 강의실에서 제거
            if (pq.peek() <= lectures[i].start) {
                pq.poll();
            }

            // 강의실 배정
            pq.offer(lectures[i].end);
            // 현재 사용 중인 강의실의 수 갱신
            max = Math.max(max, pq.size());
        }

        System.out.println(max);
    }

    static class Lecture implements Comparable<Lecture> {
        private final int start;
        private final int end;

        public Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lecture o) {
            if (start == o.start) {
                return end - o.end;
            }
            return start - o.start;
        }
    }

    static class ScannerReader {

        private final BufferedReader br;
        private StringTokenizer st;

        public ScannerReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String readLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }

        private String next() {
            while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(readLine());
            }

            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
