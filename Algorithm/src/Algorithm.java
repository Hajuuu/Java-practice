import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Algorithm {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		int[] copyArr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = copyArr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(copyArr);
		
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		
		int j = 0;
		for(int i : copyArr) {
			if(!hashMap.containsKey(i)) {
				hashMap.put(i, j);
				j++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i : arr) {
			sb.append(hashMap.get(i) + " ");
		}
		
		System.out.println(sb);
	}
} 
