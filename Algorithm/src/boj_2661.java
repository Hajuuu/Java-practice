import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        findSequence(N, "");
    }


    public static void findSequence(int N, String seq) {
        if (seq.length() == N) {
            System.out.println(seq);
            System.exit(0);
        }
        for (int i = 1; i <= 3; i++) {
            if (checkSequence(seq + i)) {
                findSequence(N, seq + i);
            }
        }
    }

    public static boolean checkSequence(String seq) {
        for (int i = 1; i <= seq.length() / 2; i++) {
            String front = seq.substring(seq.length() - i * 2, seq.length() - i);
            String back = seq.substring(seq.length() - i);
            if (front.equals(back)) {
                return false;
            }
        }
        return true;
    }
}
