import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String n = st.nextToken();
        long decimal = 0;
        int b = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n.length(); i++) {
            if(n.charAt(i) >= 'A' && n.charAt(i) <= 'Z') {
                decimal += Math.pow(b, n.length() - i - 1) * (n.charAt(i) - 'A' + 10);
            }
            else {
                decimal += Math.pow(b, n.length() - i - 1) * (n.charAt(i) - '0');
            }
        }
        System.out.println(decimal);
    }
}
