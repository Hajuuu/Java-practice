import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class boj_15666 {

	static ArrayList<Integer> list;
	static int M;
	static StringBuilder sb = new StringBuilder();
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		Set<Integer> set = new HashSet<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		list = new ArrayList<>(set);
		Collections.sort(list);
		arr = new int[M];
		dfs(0, 0);
		System.out.println(sb);
	}
	
	public static void dfs(int start, int depth) {
		if(depth == M) {
			for(int i : arr) {
				sb.append(i + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = start; i < list.size(); i++) {
			arr[depth] = list.get(i);
			dfs(i, depth + 1);
			
		}
	}
}
