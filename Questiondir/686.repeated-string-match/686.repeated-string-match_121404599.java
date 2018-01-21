class Solution {
    public int repeatedStringMatch(String A, String B) {
        Set<Character> seta = new HashSet<>();
        for (int i = 0; i < A.length(); i++) {
            seta.add(A.charAt(i));
        }
        for (int i = 0; i < B.length(); i++) {
            if (!seta.contains(B.charAt(i))) {
                return -1;
            }
        }

        String str = "";
        for (int k = 0; k < B.length(); k++) {
            str += A;
            if (str.contains(B)) {
                return k+1;
            }
        }
        return -1;
    }
}