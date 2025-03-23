import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] prime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;
        
        makePrime(1000);


        for(int i = 0; i < n; i++) {
            if(prime[Integer.parseInt(st.nextToken())]) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static void makePrime(int c) {
        prime = new boolean[c + 1];
        
        for(int i = 0; i <= c; i++) {
            prime[i] = true;
        }
        prime[0] = false;
        prime[1] = false;

        for(int i = 2; i <= Math.sqrt(c); i++) {
            if(!prime[i]) {
                continue;
            }
            for(int j = i * i; j <= c; j += i) {
                prime[j] = false;
            }
        }
    }
}
