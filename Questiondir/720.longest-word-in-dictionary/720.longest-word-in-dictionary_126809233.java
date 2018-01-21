class Solution {
    public String longestWord(String[] words) {
        int n=words.length;
        Arrays.sort(words,(a,b)->(a.length()==b.length())?(a.compareTo(b)):(a.length()-b.length()));
        boolean[] bo=new boolean[n];
        for (int i=0;i<n;i++)
        {
            String s=words[i];
            int l=s.length();
            if (s.length()==1) bo[i]=true;
            else
            {
                for (int j=i-1;j>=0;j--)
                if (bo[j])
                {
                    if (words[j].length()<l-1) break;
                    if (words[j].length()==l) continue;
                    if (words[j].equals(s.substring(0,l-1)))
                    {
                        bo[i]=true;
                        break;
                    }
                }
            }
        }
        int max=0;
        String ans="";
        for (int i=0;i<n;i++)
            if (bo[i])
            {
                if (max<words[i].length())
                {
                    max=words[i].length();
                    ans=words[i];
                }
            }
        return ans;
    }
}