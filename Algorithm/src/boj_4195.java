import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj_4195 {

	static int[] parent;
	static int[] count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 0; tc < T; tc++) {
			int F = Integer.parseInt(br.readLine());
			
			parent = new int[F * 2];
			count = new int[F * 2];
			
			for(int i = 0; i < F * 2; i++) {
				parent[i] = i;
				count[i] = 1;
			}
			
			int idx = 0;
			HashMap<String, Integer> map = new HashMap<>();
			
			for(int i = 0; i < F; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String a = st.nextToken();
				String b = st.nextToken();
				
						
				if(!map.containsKey(a)) {
					map.put(a, idx++);
				}
				
				if(!map.containsKey(b)) {
					map.put(b, idx++);
				}
				
				sb.append(unionParent(map.get(a), map.get(b)) + "\n");
			}
			
			
		}
		System.out.println(sb);
	}
	
	public static int getParent(int x) {
		if(parent[x] == x) return x;
		return parent[x] = getParent(parent[x]);
	}
	
	public static int unionParent(int a, int b) {
		a = getParent(a);
		b = getParent(b);
		
		if(a != b) {
			parent[b] = a;
			count[a] += count[b];
		}
		
		return count[a];
	}

}
