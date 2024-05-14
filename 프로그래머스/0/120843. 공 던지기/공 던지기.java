class Solution {
    public int solution(int[] numbers, int k) {
        int N = numbers.length; 
        return numbers[((k-1)*2)%N];
    }
}