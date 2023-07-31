import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int[] parent = new int[n]; //Union find 부모노드(섬) 저장
        
        //초기 부모는 나 자신
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        
        //비용 오름차순으로 정렬
        Arrays.sort(costs,(o1,o2)-> o1[2] - o2[2]);
        
        
        for(int i=0;i<costs.length;i++){
            //부모노드가 다를 때, 비용 추가(=간선 선택) 및 연결
            if(find(parent,costs[i][0]) != find(parent,costs[i][1])){
                union(parent,costs[i][0],costs[i][1]);
                answer+=costs[i][2];
            }
        }
            
        return answer;
    }
    
    private int find(int[] parent,int x){
        if(parent[x]==x){
            return x;
        }
        return find(parent,parent[x]);
    }
    
    private void union(int[] parent, int x, int y){
        int a=find(parent,x);
        int b=find(parent,y);
        parent[a]=b;
    }
}
