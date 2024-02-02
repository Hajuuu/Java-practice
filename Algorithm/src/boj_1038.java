import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class boj_1038 {

	static int N;
	static ArrayList<Long> decNumbers;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		decNumbers = new ArrayList<>();
		for(int i = 0; i <= 9; i++) {
			backTracking(i, 1);
		}
		
		Collections.sort(decNumbers);
		if(N >= decNumbers.size()) {
			System.out.println(-1);
			return;
		}
		System.out.println(decNumbers.get(N));
	}
	
	public static void backTracking(long num, int depth) {
		if(depth > 10) {
			return;
		}
		decNumbers.add(num);
		for(int i = 0; i < num % 10; i++) {
			backTracking(num * 10 + i, depth + 1);
			
		}
	}
}
