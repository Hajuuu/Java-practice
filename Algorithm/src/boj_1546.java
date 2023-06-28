import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1546 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] score = new int[N];
		double sum = 0;
		for(int i = 0; i < N; i++) {
			score[i] = Integer.parseInt(st.nextToken());
			sum += score[i];
		}
		
		Arrays.sort(score);
		
		double M = score[N - 1];
		sum = sum / M * 100 / N;
		System.out.println(sum);
	}

}
