import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1516 {

	static ArrayList<Integer>[] nodeList;
	static int[] time;
	static int[] inDegree;
	static int N;
	static int[] result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		nodeList = new ArrayList[N + 1];
		time = new int[N + 1];
		inDegree = new int[N + 1];
		result = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			nodeList[i] = new ArrayList<>();
		}
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			time[i] = n;
			while(true) {
				int x = Integer.parseInt(st.nextToken());
				if(x == -1) {
					break;
				}
				nodeList[i].add(x);
				inDegree[x]++;
			}
		}
		
		topologySort();
		
		int[] count = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			int n = result[N - i + 1];
			count[n] += time[n];
			if(nodeList[n].size() > 0) {
				int max = Integer.MIN_VALUE;
				for(int j : nodeList[n]) {
					max = Math.max(max, count[j]);
				}
				
				count[n] += max;
			}
			
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++) {
			sb.append(count[i] + "\n");
		}
		
		System.out.println(sb);
	}
	
	public static void topologySort() {
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i = 1; i <= N; i++) {
			if(inDegree[i] == 0) {
				queue.offer(i);
			}
		}
		
		for(int i = 1; i <= N; i++) {
			int x = queue.poll();
			result[i] = x;
			for(int j : nodeList[x]) {
				if(--inDegree[j] == 0) {
					queue.offer(j);
				}
			}
		}
	}
	
}
