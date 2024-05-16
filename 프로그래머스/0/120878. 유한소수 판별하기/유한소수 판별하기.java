class Solution {
    public int solution(int a, int b) {
        int answer = 2;
        for (int i=2; i<Math.min(a, b) + 1; i++) {
            if (a % i == 0 && b % i == 0) {
                a /= i;
                b /= i;
            }
        }
        if (check(b)) {
            answer = 1;
        }
        return answer;
    }

    public boolean check(int num){
        while (num > 1) {
            if (num % 2 == 0) {
                num /= 2;
            } else if (num % 5 == 0) {
                num /= 5;
            } else {
                return false;
            }
        }
        return true;
    }
}