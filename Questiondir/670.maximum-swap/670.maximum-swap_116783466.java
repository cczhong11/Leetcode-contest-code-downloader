class Solution {
    public int maximumSwap(int num) {
        String s=num+"";
        int len=s.length();
        int[] a=new int[len];
        for (int i=0;i<len;i++) a[i]=s.charAt(i)-48;
        for (int i=0;i<len;i++)
        {
            int now=a[i],max=-1,maxj=0;
            for (int j=i+1;j<len;j++)
                if (max<=a[j])
                {
                    max=a[j];
                    maxj=j;
                }
            if (max<=now) continue;
            int t=a[i];
            a[i]=a[maxj];
            a[maxj]=t;
            break;
        }
        int ans=0;
        for (int i=0;i<len;i++) ans=ans*10+a[i];
        return ans;
    }
}