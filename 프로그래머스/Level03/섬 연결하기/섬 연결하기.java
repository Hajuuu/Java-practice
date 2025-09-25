import java.util.*;
class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
    	
    	boolean[] visit = new boolean[n]; 
    	List<List<int[]>> adjList = new ArrayList<>();
    	PriorityQueue<int[]> pqueue = new PriorityQueue<>( (x, y) -> x[1] - y[1]);
    	
    	for (int i = 0; i < n; i++) {
			adjList.add(new ArrayList<>());
		}
    	
    	for (int[] e : costs) {
			int a = e[0]; 
			int b = e[1]; 
			int c = e[2]; 
			
			adjList.get(a).add(new int[] {b, c});
			adjList.get(b).add(new int[] {a, c});
		}
    	
    	visit[0] = true;
    	for (int[] edge : adjList.get(0)) {
			pqueue.offer(new int[] { edge[0], edge[1] });
		}
        
    	int count = 0;
    	while( ! pqueue.isEmpty() ) {
    		
    		int[] cur = pqueue.poll(); 
    		int v = cur[0]; 
    		int c = cur[1]; 
    		
    		if(visit[v]) continue;
    		visit[v] = true;
    		answer += c;
    		count++;
    		
    		if( count == n ) break;
    		
    		for (int[] e : adjList.get(v)) {
				pqueue.offer(new int[] {e[0], e[1]});
			}
    	}
    	
        return answer;
    }
}
