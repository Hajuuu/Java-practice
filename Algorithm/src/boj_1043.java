import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_1043 {

	static int[] person;
	static int[] parent;
	static ArrayList<Integer>[] party;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		parent = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
		st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		
		
		if(p == 0) {
			person = new int[1];
			person[0] = 0;
		} else {
			person = new int[p];
			for(int i = 0; i < p; i++) {
				person[i] = Integer.parseInt(st.nextToken());
			}
		}
		
		party = new ArrayList[M];
		
		for(int i = 0; i < M; i++) {
			party[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			int count = Integer.parseInt(st.nextToken());
			for(int j = 0; j < count; j++) {
				party[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		for(int i = 0; i < M; i++) {
			int first = party[i].get(0);
			for(int j = 1; j < party[i].size(); j++) {
				int next = party[i].get(j);
				union(first, next);
			}
		}
		
		int count = 0;
		for(int i = 0; i < M; i++) {
			boolean check = true;
			int num = party[i].get(0);
			for(int j = 0; j < person.length; j++) {
				int pNum = person[j];
				if(getParent(num) == getParent(pNum)) {
					check = false;
				}
			}
			if(check) {
				count++;
			}
		}
		
		System.out.println(count);
	}
	
	public static int getParent(int num) {
		if(num == parent[num]) return num;
		return parent[num] = getParent(parent[num]);
	}
	
	public static void union(int a, int b) {
		a = getParent(a);
		b = getParent(b);
		
		if(a != b) {
			parent[b] = a;
		}
	}
	
}
