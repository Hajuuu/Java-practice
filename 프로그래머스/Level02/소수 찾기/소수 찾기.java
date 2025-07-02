import java.util.*;
class Solution {
    static Set<Integer> primes;
    static boolean[] visited;
    public int solution(String numbers) {
        primes = new HashSet<>();
        visited = new boolean[numbers.length()];
        findNumbers("0", numbers);
        return primes.size();
    }
    
    public void findNumbers(String num, String numbers) {
        if(isPrime(Integer.parseInt(num))) {
            primes.add(Integer.parseInt(num));
        }
        
        for(int i = 0; i < numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                findNumbers(num + numbers.charAt(i), numbers);
                visited[i] = false;
            }
        }
    }
    
    public static boolean isPrime(int num) {
        if(num == 0 || num == 1) {
            return false;
        }
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
