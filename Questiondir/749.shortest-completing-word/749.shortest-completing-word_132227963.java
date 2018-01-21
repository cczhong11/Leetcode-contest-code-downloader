class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] count=new int[26];
        for (int i=0;i<licensePlate.length();i++)
        {
            char ch=licensePlate.charAt(i);
            if (ch>='A' && ch<='Z') count[ch-65]++;
            if (ch>='a' && ch<='z') count[ch-97]++;
        }
        String ans="";
        int min=10000000;
        for (String s:words)
        {
            int[] count2=new int[26];
            for (int i=0;i<s.length();i++)
            {
                char ch=s.charAt(i);
                if (ch>='A' && ch<='Z') count2[ch-65]++;
                if (ch>='a' && ch<='z') count2[ch-97]++;
            }
            boolean bo=true;
            for (int i=0;i<26;i++)
                if (count2[i]<count[i]) bo=false;
            if (bo)
            {
                if (min>s.length())
                {
                    min=s.length();
                    ans=s;
                }
            }
        }
        return ans;
    }
}