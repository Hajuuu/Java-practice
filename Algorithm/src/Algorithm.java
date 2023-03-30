import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Algorithm {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int result = sum(N);
		System.out.println(result);
	}
	
	static int sum(int N) {
		
		for(int i = 0; i <= 9; i++) {
			for(int j = 0; j <= 9; j++) {
				for(int k = 0; k <= 9; k++) {
					for(int a = 0; a <= 9; a++) {
						for(int b = 0; b <= 9; b++) {
							for(int c = 0; c <= 9; c++) {
								int tmp = i * 100000 + j * 10000 + k * 1000 + a * 100 + b * 10 + c;
								if(i + j + k + a + b + c + tmp == N)
									return tmp;
							}
						}
					}
				}
			}
		}
		
		return 0;
	}
} 
