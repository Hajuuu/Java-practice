import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Algorithm {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int[] arr = new int[3];
		
		for(int i = 0; i < 3; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		if(arr[2] >= arr[0] + arr[1]) {
			System.out.println(arr[0] * 2 + arr[1] * 2 - 1);
		} else {
			System.out.println(arr[0] + arr[1] + arr[2]);
		}
		
		
		
		    
	}
}
