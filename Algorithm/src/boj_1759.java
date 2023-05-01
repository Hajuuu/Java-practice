import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1759 {

	static char[] list;
	static char[] dlist;
	static boolean[] visited;
	static int L, C;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		list = new char[C];
		dlist = new char[L];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < C; i++) {
			list[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(list);
		DFS(0, 0);
		System.out.println(sb);
	}
	
	public static void DFS(int at, int depth) {
		if(depth == L) {
			if(isValid()) {
				for(int i = 0; i < L; i++) {
					sb.append(dlist[i]);
				}
				sb.append("\n");
			}
			return;
		}
		
		for(int i = at; i < C; i++) {
			dlist[depth] = list[i];
			DFS(i + 1, depth + 1);
			
		}
	}
	
	public static boolean isValid() {
		int count1 = 0;
		int count2 = 0;
		
		for(char i : dlist) {
			if(i == 'a' || i == 'e' || i == 'i' || i == 'o' ||i == 'u') {
				count1++;
			} else {
				count2++;
			}
		}
		
		if(count1 >= 1 && count2 >= 2) {
			return true;
		}
		return false;
	}

}
