class Solution {
    public int countBinarySubstrings(String s) {
        int n=s.length(),last=0,p=0;
        int[] a=new int[n];
        for (int i=0;i<=n;i++)
            if (i==n || s.charAt(i)!=s.charAt(last))
            {
                a[p]=i-last;
                p++;
                last=i;
            }
        int ans=0;
        for (int i=1;i<p;i++) ans+=Math.min(a[i],a[i-1]);
        return ans;
    }
}