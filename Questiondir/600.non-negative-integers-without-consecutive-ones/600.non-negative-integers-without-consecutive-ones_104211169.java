public class Solution {
    public int findIntegers(int num) {
        if (num==0) return 1;
        if (num==1) return 2;
        int[][] b=new int[51][2];
        b[1][0]=1;
        b[1][1]=1;
        for (int i=2;i<=50;i++) {
            b[i][0]=b[i-1][0]+b[i-1][1];
            b[i][1]=b[i-1][0];
        }
        int[] a=new int[100];
        int t=num;
        int k=0;
        while (t>0) {
            a[k]=t%2;
            k++;
            t=t/2;
        }
        //System.out.println(k);
        int ret=b[k][0];
        for (int i=k-2;i>=0;i--) {
            if (i==0 && a[0]==0) {
                ret++;
                break;
            }
            if (a[i]==0) continue;
            if (a[i+1]==1) {
                ret+=b[i+1][0];
                break;
            }
            if (i==0) {
                ret+=2;
                break;
            }
            ret+=b[i+1][0];
            
        }
        return ret;
    }
}