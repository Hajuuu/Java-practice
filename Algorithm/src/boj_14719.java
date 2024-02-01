import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_14719 {

	static int[] block;
	static int water = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		block = new int[W];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < W; i++) {
			block[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i < W - 1; i++) {
			if(block[i] <= block[i + 1])
				continue;
			for(int j = i + 1; j < W; j++) {
				countWater(i, j);
			}
		}
		
		System.out.println(water);
	}
 
	public static void countWater(int start, int end) {
		Queue<Integer> queue = new ArrayDeque<>();
		for(int i = start + 1; i < end; i++) {
			if(block[start] > block[i] && block[end] > block[i]) {
				queue.offer(i);
			}
			if(block[i] > block[start] || block[i] > block[end]) {
				break;
			}
			
		}
		int min = Math.min(block[start], block[end]);
		while(!queue.isEmpty()) {
			int num = queue.poll();
			water += min - block[num];
			block[num] += min - block[num];
		}
	}
}

