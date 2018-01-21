class Solution {
    public int repeatedStringMatch(String A, String B) {
        String newB = B.replaceAll(A, "");
        if (newB.equals(""))
            return B.length()/A.length();
        else{
            if (A.indexOf(newB)>=0) return ((B.length()-newB.length())/A.length() + 1);
            if ((A+A).indexOf(newB)>=0) return ((B.length()-newB.length())/A.length() + 2);
            return -1;
        }
    }
}