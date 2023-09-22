import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_1068 {

	static ArrayList<Integer>[] nodeList;
	static int[] count;
	static int r;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		nodeList = new ArrayList[N];
		count = new int[N];
		
		for(int i = 0; i < N; i++) {
			nodeList[i] = new ArrayList<>();
		}
		
		int start = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int parent = Integer.parseInt(st.nextToken());
			if(parent == -1) {
				start = i;
				continue;
			}
			nodeList[parent].add(i);
		}
		r = Integer.parseInt(br.readLine());
		dfs(start);
		remove(r);
		int answer = 0;
		
		for(int i = 0; i < N; i++) {
			if(count[i] == 0) {
				answer++;
			}
		}
		System.out.println(answer);
	} 
	
	public static void remove(int start) {
		count[start] = -1;
		for(int i : nodeList[start]) {
			remove(i);
		}
	}
	
	public static void dfs(int start) {
		for(int i : nodeList[start]) {
			if(i == r) continue;
			count[start] += 1;
			dfs(i);
		}
	}
}
