import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_18352 {

	static ArrayList<Integer>[] nodeList;
	static int K;
	static StringBuilder sb = new StringBuilder();
	static int[] num;
	static ArrayList<Integer> ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		nodeList = new ArrayList[N + 1];
		num = new int[N + 1];
		ans = new ArrayList<>();
		for(int i = 1; i <= N; i++) {
			nodeList[i] = new ArrayList<>();
		}
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			nodeList[a].add(b);
		}
		BFS(X);
		
		
		if(ans.isEmpty()) {
			System.out.println(-1);
			return;
		}
		Collections.sort(ans);
		for(int i : ans) {
			sb.append(i + "\n");
		}

		System.out.println(sb);
	}
	
	public static void BFS(int x) {
		Queue<Integer> queue = new LinkedList<>();
		boolean check = false;
		queue.offer(x);
		num[x] = 1;
		while(!queue.isEmpty()) {
			x = queue.poll();
			if(num[x] == K + 1) {
				ans.add(x);
			}
			for(int i = 0; i < nodeList[x].size(); i++) {
				int now = nodeList[x].get(i);
				if(num[now] == 0) {
					num[now] += num[x] + 1;
					queue.offer(now);
				}
			}
 		}
	}

}
