class Solution {
    
    public int numJewelsInStones(String J, String S) {
        Set<Character> j = new HashSet<>();
        for (int i = 0; i < J.length(); i++) j.add(J.charAt(i));
        int  res = 0;
        for (int i = 0; i < S.length(); i++) {
            if (j.contains(S.charAt(i))) res++;
        }
        return res;
    }
    
}