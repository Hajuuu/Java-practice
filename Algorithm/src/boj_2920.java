import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2920 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[9];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i <= 8; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		if(ascending(arr)) {
			System.out.println("ascending");
		} else if(descending(arr)) {
			System.out.println("descending");
		} else {
			System.out.println("mixed");
		}
	}
	
	public static boolean ascending(int[] arr) {
		for(int i = 1; i <= 8; i++) {
			if(arr[i] != i) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean descending(int[] arr) {
		for(int i = 1; i <= 8; i++) {
			if(arr[i] != (9 - i)) {
				return false;
			}
		}
		return true;
	}

}
