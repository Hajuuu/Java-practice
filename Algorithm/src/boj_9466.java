import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<Integer>[] nodeList;
	static boolean[] visit;
	static int N; 
	static Set<Integer> set;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());
			nodeList = new ArrayList[N + 1];
			visit = new boolean[N + 1];
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= N; i++) {
				nodeList[i] = new ArrayList<>();
			}
			int answer = 0;
			for(int i = 0; i < N; i++) {
				int x = Integer.parseInt(st.nextToken());
				nodeList[i + 1].add(x);
				if(x == (i + 1)) {
					visit[x] = true;
					answer++;
				}
			}
			set = new HashSet<>();
			
			for(int i = 1; i <= N; i++) {
				set = new HashSet<>();
				if(!visit[i]) {
					boolean check = dfs(i);
					if(check) {
						answer += set.size();
					}
				}
				
			}
			
			sb.append(N - answer + "\n");
		}
		System.out.println(sb);
	}
	
	public static boolean dfs(int num) {
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> check = new Stack<>();
		stack.push(num);
		check.push(num);
		set.add(num);
		visit[num] = true;
		while(!stack.isEmpty()) {
			int now = stack.pop();
			for(int i : nodeList[now]) {
				if(check.contains(i)) {
					visit[i] = true;
					return true;
				}
				if(!visit[i]) {
					visit[i] = true;
					set.add(i);
					stack.push(i);
					check.push(i);
				}
			}
		}
		return false;
	}

}
