class Solution {
    public String reorganizeString(String S) {
        int[] count=new int[26];
        for (int i=0;i<S.length();i++) count[S.charAt(i)-97]++;
        int last=-1;
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<S.length();i++)
        {
            int max=0,maxj=0;
            for (int j=0;j<26;j++)
            {
                if (j!=last && count[j]>max) 
                {
                    max=count[j];
                    maxj=j;
                }
            }
            if (max==0) return "";
            sb.append((char)(maxj+97));
            count[maxj]--;
            last=maxj;
        }
        return sb+"";
    }
}