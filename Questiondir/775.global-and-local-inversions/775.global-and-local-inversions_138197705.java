class Solution {
    public int numJewelsInStones(String J, String S) {
        int sum = 0;
        for (int i = 0; i < S.length(); i++) {
        		if (J.contains(S.substring(i, i + 1)) ) {
        			sum++;
        		}
        }
        return sum;
    }

}