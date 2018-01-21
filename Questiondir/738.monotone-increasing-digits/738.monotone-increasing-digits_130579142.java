class Solution {
    public int monotoneIncreasingDigits(int N) {
        String s=N+"";
        int n=s.length();
        int x=0,ans=0;
        while (x+1<n && s.charAt(x)<=s.charAt(x+1)) 
        {
            ans=ans*10+(s.charAt(x)-48);
            x++;
        }
        if (x==n-1) return N;
        while (x>0 && s.charAt(x)==s.charAt(x-1)) 
        {
            x--;
            ans/=10;
        }
        ans=ans*10+(s.charAt(x)-49);
        for (int i=x+1;i<n;i++) ans=ans*10+9;
        return ans;
    }
}