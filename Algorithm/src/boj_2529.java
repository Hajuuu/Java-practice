import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_2529 {

	static int[] arr;
	static boolean[] visit;
	static String[] inequality;
	static int k;
	static ArrayList<String> answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[k + 1];
		visit = new boolean[10];
		inequality = new String[k + 1];
		answer = new ArrayList<>();
		
		for(int i = 1; i <= k; i++) {
			inequality[i] = st.nextToken();
		}
		dfs(0);
		
		System.out.println(answer.get(answer.size() - 1));
		System.out.println(answer.get(0));
		
	}
	
	public static void dfs(int depth) {
		if(depth == (k + 1)) {
			String str = "";
			for(int i : arr) {
				str += (i + "");
			}
			answer.add(str);
			return;
		}
		
		for(int i = 0; i <= 9; i++) {
			if(visit[i]) {
				continue;
			}
			arr[depth] = i;
			if(check(depth)) {
				visit[i] = true;
				dfs(depth + 1);
				visit[i] = false;
			} 
			
		}
	}
	
	public static boolean check(int num) {
		if(num == 0) {
			return true;
		}
		String in = inequality[num];
		if(in.equals(">")) {
			if(arr[num - 1] > arr[num]) {
				return true;
			} else {
				return false;
			}
		}
		else {
			if(arr[num - 1] < arr[num]) {
				return true;
			} else {
				return false;
			}
		}
	}

}
