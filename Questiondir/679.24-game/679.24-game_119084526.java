class Solution {
    boolean ok2(double a,double b)
    {
        return (a+b==24 || a-b==24 || a*b==24 || a/b==24);
    }
    boolean ok3(double a,double b,double c)
    {
        if (ok2(a+b,c)) return true;
        if (ok2(a-b,c)) return true;
        if (ok2(a*b,c)) return true;
        if (ok2(a/b,c)) return true;
        if (ok2(c,a+b)) return true;
        if (ok2(c,a-b)) return true;
        if (ok2(c,a*b)) return true;
        if (ok2(c,a/b)) return true;
        return false;
    }
    boolean ok4(double a,double b,double c,double d)
    {
        double[] s1=new double[]{a+b,a-b,a*b,a/b};
        double[] s2=new double[]{c+d,c-d,c*d,c/d};
        for (int i=0;i<4;i++)
            for (int j=0;j<4;j++)
                if (ok2(s1[i],s2[j])) return true;
        if (ok3(a+b,c,d)) return true;
        if (ok3(a-b,c,d)) return true;
        if (ok3(a*b,c,d)) return true;
        if (ok3(a/b,c,d)) return true;
        if (ok3(c,a+b,d)) return true;
        if (ok3(c,a-b,d)) return true;
        if (ok3(c,a*b,d)) return true;
        if (ok3(c,a/b,d)) return true;
        if (ok3(c,d,a+b)) return true;
        if (ok3(c,d,a-b)) return true;
        if (ok3(c,d,a*b)) return true;
        if (ok3(c,d,a/b)) return true;
        return false;
    }
    public boolean judgePoint24(int[] nums) {
        int a=nums[0],b=nums[1],c=nums[2],d=nums[3];
        if (ok4(a,b,c,d)) return true;
        if (ok4(a,b,d,c)) return true;
        if (ok4(a,c,b,d)) return true;
        if (ok4(a,c,d,b)) return true;
        if (ok4(a,d,b,c)) return true;
        if (ok4(a,d,c,b)) return true;
        if (ok4(b,a,c,d)) return true;
        if (ok4(b,a,d,c)) return true;
        if (ok4(b,c,a,d)) return true;
        if (ok4(b,c,d,a)) return true;
        if (ok4(b,d,a,c)) return true;
        if (ok4(b,d,c,a)) return true;
        if (ok4(c,a,b,d)) return true;
        if (ok4(c,a,d,b)) return true;
        if (ok4(c,b,a,d)) return true;
        if (ok4(c,b,d,a)) return true;
        if (ok4(c,d,a,b)) return true;
        if (ok4(c,d,b,a)) return true;
        if (ok4(d,a,b,c)) return true;
        if (ok4(d,a,c,b)) return true;
        if (ok4(d,b,a,c)) return true;
        if (ok4(d,b,c,a)) return true;
        if (ok4(d,c,a,b)) return true;
        if (ok4(d,c,b,a)) return true;
        return false;
    }
}
