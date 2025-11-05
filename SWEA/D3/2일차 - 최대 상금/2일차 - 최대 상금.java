import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static char[] arr;
	static int count;
	static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			count = Integer.parseInt(st.nextToken());
			arr = new char[str.length()];
            max = 0;
			for(int j = 0; j < arr.length; j++) {
				arr[j] = str.charAt(j);
			}
			if(count > arr.length) {
				count = arr.length;
			}
			DFS(0, 0);
			sb.append("#" + i + " " + max + "\n");
			
		}
		System.out.println(sb);
	}
	
	public static void DFS(int start, int depth) {
		if(depth == count) {
			String str = "";
			for(int i = 0; i < arr.length; i++) {
				str += arr[i];
			}
			max = Math.max(max, Integer.parseInt(str));
			return;
		}
		
		for(int i = start; i < arr.length; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				char tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				
				DFS(i, depth + 1);
				
				char tmp1 = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp1;
			}
		}
	}

}
