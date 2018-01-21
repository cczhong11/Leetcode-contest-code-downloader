class Solution {
    public int findKthNumber(int m, int n, int k) {
        int l=0,r=m*n;
        while (l<r)
        {
            int mid=(l+r)/2;
            int x=0,y=0;
            for (int i=1;i<=m;i++)
            {
                int s=mid/i,kk=0;
                if (mid%i==0) kk=-1;
                x+=Math.min(s+kk,n);
                y+=Math.min(s,n);
            }
            if (x<k && y>=k) return mid;
            if (y<k) l=mid+1; else r=mid-1;          
        }
        return l;
    }
}