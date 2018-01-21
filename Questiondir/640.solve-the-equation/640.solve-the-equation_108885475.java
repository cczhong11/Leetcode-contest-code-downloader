
public class Solution {
    int[] cal(String s)
    {
        int[] ans={0,0};
        int n=s.length(),num=0,sign=1;
        boolean bo=false;
        for (int i=0;i<n;i++)
        {
            char ch=s.charAt(i);
            if (ch=='x')
            {
                bo=true;
                if (num==0 && (i==0 || s.charAt(i-1)!='0')) num=1;
            }
            if (ch=='+')
            {
                if (bo) ans[0]+=num*sign; else ans[1]+=num*sign;
                num=0;
                sign=1;
                bo=false;
            }
            if (ch=='-')
            {
                if (bo) ans[0]+=num*sign; else ans[1]+=num*sign;
                num=0;
                sign=-1;
                bo=false;
            }
            if (Character.isDigit(ch)) num=num*10+ch-48;
        }
        return ans;
    }
    public String solveEquation(String equation) {
        int e=equation.indexOf("=");
        String Left=equation.substring(0,e);
        String Right=equation.substring(e+1);
        int[] l=cal(Left+"+");
        int[] r=cal(Right+"+");
        //return ""+l[0]+" "+l[1]+" "+r[0]+" "+r[1];
        l[0]-=r[0];
        l[1]-=r[1];
        if (l[0]!=0) return "x="+(-l[1]/l[0]);
        else
        {
            if (l[1]==0) return "Infinite solutions";
            else return "No solution";
        }
        //return Left;
    }
}