public class Solution {
    int mo=1000000007;
    public int numDecodings(String s) {
        int n=s.length();
        long[] f=new long[n+1];
        f[0]=1;
        for (int i=1;i<=n;i++)
        {
            char ch=s.charAt(i-1);
            if (ch=='*') f[i]=(f[i-1]*9)%mo; 
            else f[i]=(ch=='0')?0:f[i-1];
            if (i>1)
            {
                char ch2=s.charAt(i-2);
                if (ch2=='*')
                {
                    if (ch=='*') f[i]=(f[i]+f[i-2]*15)%mo;
                    else if (ch>='7') f[i]=(f[i]+f[i-2])%mo;
                         else f[i]=(f[i]+f[i-2]*2)%mo;
                }
                if (ch2=='1')
                {
                    if (ch=='*') f[i]=(f[i]+f[i-2]*9)%mo; else f[i]=(f[i]+f[i-2])%mo;
                }
                if (ch2=='2')
                {
                    if (ch=='*') f[i]=(f[i]+f[i-2]*6)%mo;
                    else if (ch<'7') f[i]=(f[i]+f[i-2])%mo;
                }
            }
        }
        return (int)f[n];
    }
}