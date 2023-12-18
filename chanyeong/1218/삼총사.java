class Solution {
    static boolean[] visited;
    static int[] arr;
    static int answer;

    public int solution(int[] number) {
        visited = new boolean[number.length];
        arr = new int[3];
        dfs(number, 0, 0);
        return answer;
    }

    private void dfs(int[] numbers, int index, int L) {
        if(L == 3) {
            if(isCkecked()) {
                answer++;
            }
            return;
        }

        for(int i=index; i< numbers.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[L] = numbers[i];
                dfs(numbers, i + 1, L + 1);
                visited[i] = false;
            }
        }
    }

    private boolean isCkecked() {
        int sum = 0;
        for(int i=0; i<3; i++) {
            sum += arr[i];
        }
        return sum == 0;
    }
}
