class Solution {
    int tot=0;
    int get(int[] sum,int c)
    {
        if (c<0) return 0; 
        else return sum[c];
    }
    int cal(int x,int[] nums,int[] count,int[] sum)
    {
        if (x==0) return 0;
        int n=nums.length,ans=tot;
        for (int now:nums)
        {
            ans+=get(sum,now-1)-get(sum,now-x);
        }
        return ans;
    }
    public int smallestDistancePair(int[] nums, int k) {
        int n=nums.length;
        int[] count=new int[1000000];
        int[] sum=new int[1000000];
        for (int i=0;i<n;i++) count[nums[i]]++;
        sum[0]=count[0];
        for (int i=1;i<1000000;i++) sum[i]=sum[i-1]+count[i];
        for (int i=0;i<1000000;i++) tot+=(count[i]-1)*count[i]/2;
        int l=0,r=1000000;
        //return cal(1,nums,count,sum);
        //return tot;
        while (l+1<r)
        {
            int mid=(l+r)/2;
            if (cal(mid,nums,count,sum)<k) l=mid; else r=mid;
        }
        return l;
    }
}