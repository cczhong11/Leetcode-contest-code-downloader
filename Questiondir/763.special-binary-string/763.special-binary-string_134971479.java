class Solution {
    public String makeLargestSpecial(String S) {
        String old = S;
        while (true) {
            String temp = mlsHelper(old);
            if (temp.equals(old))
                return temp;
            old = temp;
        }
    }
    
    public String mlsHelper(String S) {
        if (S.length() <= 4)
            return S;
        int c0 = 0;
        int c1 = 0;
        for (int i = 0; i < S.length()-2; i++) {
            if (S.charAt(i)=='0')
                c0++;
            else
                c1++;
            if (c1==c0) {
                String s3 = mlsHelper(S.substring(i+1));
                String s4 = mlsHelper(S.substring(0,i+1));
                String s1 = s4+s3;
                String s2 = s3+s4;
                if (s2.compareTo(s1)>0)
                    return s2;
                else
                    return s1;
            }
        }
        return "1"+mlsHelper(S.substring(1,S.length()-1))+"0";
    }
}