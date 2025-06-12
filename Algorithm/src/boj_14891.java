import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Integer>[] gear;
    static int[] startIndex;
    static int[] direction;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        gear = new ArrayList[4];
        startIndex = new int[4];
        direction = new int[4];
        StringTokenizer st;
        for (int i = 0; i < 4; i++) {
            gear[i] = new ArrayList<>();
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                gear[i].add(input.charAt(j) - '0');
            }
        }

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken()) - 1;
            int rotation = Integer.parseInt(st.nextToken());
            direction[number] = rotation;
            checkLeft(number);
            checkRight(number);
            for (int j = 0; j < 4; j++) {
                if (direction[j] == 0) {
                    continue;
                }
                rotateGear(j, direction[j]);
                direction[j] = 0;
            }
        }


        int answer = 0;
        for (int i = 0; i < 4; i++) {
            if (gear[i].get(startIndex[i]) == 0) {
                continue;
            }
            answer += (int) Math.pow(2, i);
        }

        System.out.println(answer);
    }

    public static void checkLeft(int number) {
        if (number - 1 >= 0) {
            int gearLeft = number - 1;
            if (gear[gearLeft].get((startIndex[gearLeft] + 2) % 8) != gear[number].get((startIndex[number] + 6) % 8)) {
                direction[gearLeft] = direction[number] * -1;
                checkLeft(gearLeft);
            }

        }

    }

    public static void checkRight(int number) {
        if (number + 1 < gear.length) {
            int gearRight = number + 1;
            if (gear[gearRight].get((startIndex[gearRight] + 6) % 8) != gear[number].get((startIndex[number] + 2) % 8)) {
                direction[gearRight] = direction[number] * -1;
                checkRight(gearRight);
            }

        }
    }

    public static void rotateGear(int number, int rotation) {
        if (rotation == 1) {
            startIndex[number] = (startIndex[number] + 7) % 8;
            return;
        }
        startIndex[number] = (startIndex[number] + 1) % 8;
    }

}
