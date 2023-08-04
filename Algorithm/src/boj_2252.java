import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2252 {

	static ArrayList<Integer>[] nodeList;
	static int[] inDegree;
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nodeList = new ArrayList[N + 1];
		inDegree = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			nodeList[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			nodeList[a].add(b);
			inDegree[b]++;
		}
		
		topologySort();
		
		System.out.println(sb);
	}
	
	public static void topologySort() {
		Queue<Integer> queue = new LinkedList<>();		
		int[] result = new int[N + 1];
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
		
		for(int i = 1; i <= N; i++) {
			sb.append(result[i] + " ");
		}
	}
	

}
