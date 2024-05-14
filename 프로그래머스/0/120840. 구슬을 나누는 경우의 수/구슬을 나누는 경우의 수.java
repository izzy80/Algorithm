class Solution {
    public int solution(int balls, int share) {
        return combi(balls,share);
    }
    public int combi(int balls, int share){
        if(balls == share|| share == 0){
            return 1; 
        }
        return combi((balls-1), (share-1))+combi(balls-1, share);
    }
}