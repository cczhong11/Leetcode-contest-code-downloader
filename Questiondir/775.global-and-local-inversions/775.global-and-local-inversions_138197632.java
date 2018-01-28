class Solution {
    public int numJewelsInStones(String J, String S) {
        int cnt = 0;
        for(int i = 0; i < S.length(); i++){
            boolean exist = false;
            for(int j = 0; j < J.length(); j++){
                if(S.charAt(i) == J.charAt(j)){
                    exist = true;
                }
            }
            if(exist){
                cnt++;
            }
        }
        return cnt;
    }
}