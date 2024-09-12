import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class boj_19584 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TreeSet<Integer> location = new TreeSet<>();
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<Integer, Long> plus = new HashMap<>();
		HashMap<Integer, Long> minus = new HashMap<>();
		int[] arr = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[i] = y;
			location.add(y);
		}
		
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			if(arr[u] < arr[v]) {
				plus.put(arr[u], plus.getOrDefault(arr[u], 0L) + c);
				minus.put(arr[v], minus.getOrDefault(arr[v], 0L) + c);
			} else {
				plus.put(arr[v], plus.getOrDefault(arr[v], 0L) + c);
				minus.put(arr[u], minus.getOrDefault(arr[u], 0L) + c);		
			}
		}
		
		long count = 0;
		long answer = 0;
		for(int l : location) {
			count += plus.getOrDefault(l, 0L);
			answer = Math.max(answer, count);
			count -= minus.getOrDefault(l, 0L);
		}
		System.out.println(answer);
		
	} 

}