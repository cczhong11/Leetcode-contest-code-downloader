class Solution {
       public String minWindow(char[] s, int si, char[] t, int[] lefts) {
//        log.info("si: {}", si);
        int ti=0;
        lefts[0]=-1;
        while (si<s.length&&ti<t.length){
            if (s[si]==t[ti]){
//                log.info("ti matched {}", ti);
                if (++ti==1)lefts[0]=si;
            }
            ++si;
        }
        if (ti==t.length) {
            return new String(s, lefts[0], si-lefts[0]);
        } else {
            return "";
        }

    }
    public String minWindow(String S, String T) {
        char[] ss=S.toCharArray(), ts=T.toCharArray();
        String ans="";
        int si=0;
        int[]lefts=new int[1];
        while (si+T.length()<=S.length()) {
            String next=minWindow(ss, si, ts, lefts);
            if (ans.isEmpty()||(!next.isEmpty()&&next.length()<ans.length())) {
                ans=next;
            }
            if (next.isEmpty())break;
            si=lefts[0]+1;
        }
        return ans;

    }
}