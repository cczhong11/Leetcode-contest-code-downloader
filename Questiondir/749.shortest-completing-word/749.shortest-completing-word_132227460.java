class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] cict=new int[27];
        int count=0;
        for (int i=0;i<licensePlate.length();i++)
        {
            char c=licensePlate.charAt(i);
            if ((c>='A')&&(c<='Z'))
                c=(char)(c-'A'+'a');
            if ((c<'a')||(c>'z'))
                continue;
            int index=(int)(c-'a');
            cict[index]++;
            count++;
        }
        int shortlength=Integer.MAX_VALUE;
        String r="";
        for (String s:words)
        {
            if (s.length()>=shortlength)
                continue;
            int[] cct=new int[26];
            int cc=count;
            for (int i=0;i<26;i++)
            {
                cct[i]=cict[i];
            }
            for (int i=0;i<s.length();i++)
            {
                int m=(int)s.charAt(i)-'a';
                if (cct[m]>0)
                {
                    cc--;
                    cct[m]--;
                }
            }
            if (cc==0)
            {
                r=s;
                shortlength=r.length();
            }
        }
        return r;
    }
}