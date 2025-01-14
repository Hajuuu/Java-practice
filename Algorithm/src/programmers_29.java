class Solution {
    public int solution(int a, int b, int n) {
        int cola = 0;
        int answer = 0;
        while(true) {
            if((n + cola) < a) {
                break;
            }
            if(cola > 0) {
                if((n + cola) % a == 0) {
                    answer += ((n + cola) / a) * b;
                    n = ((n + cola) / a) * b;
                    cola = 0;  
                } else {
                    answer += ((n + cola) / a) * b;
                    int now = (n + cola) % a;
                    n = ((n + cola) / a) * b;
                    cola = now;
                }
                 
            } else {
                answer += (n / a) * b;
                cola = n % a;
                n = (n / a) * b;
            }
        }
        return answer;
    }
}
