import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj_14725 {

	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Node3 root = new Node3();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			Node3 now = root;
			
			for(int j = 0; j < K; j++) {
				String food = st.nextToken();
				if(!now.childs.containsKey(food)) {
					now.childs.put(food, new Node3());
				}
				now = now.childs.get(food);
			}
			
		}
		
		print(root, "");
		
		System.out.println(sb);
		
	} 
	
	public static void print(Node3 root, String ans) {
		ArrayList<String> keySet = new ArrayList<>(root.childs.keySet());
		Collections.sort(keySet);
		
		for(String s : keySet) {
			sb.append(ans + s + "\n");
			print(root.childs.get(s), ans + "--");
		}
	}

}

class Node3 {
	HashMap<String, Node3> childs = new HashMap<>();
}
