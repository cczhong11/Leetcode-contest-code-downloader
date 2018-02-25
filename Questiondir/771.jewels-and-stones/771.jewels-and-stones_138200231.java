class Solution {
    public int numJewelsInStones(String J, String S) {
        HashSet<Character> jewelry = new HashSet<Character>();
        for(char c : J.toCharArray()) jewelry.add(c);
        int ret = 0;
        for(char c : S.toCharArray()) {
            if (jewelry.contains(c)) {
                ret += 1;
            }
        }
        return ret;
    }
}