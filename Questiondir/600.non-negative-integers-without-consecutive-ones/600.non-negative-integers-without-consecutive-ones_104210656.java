public class Solution {
     public static int findIntegers(int n){
        int[]s = new int[32];
        int[]psum = new int[32];
        psum[0]=s[0]=2; //0 or 1;
        s[1]=1; //10
        s[2]=2; //100, 110;
        psum[1]=s[1]+psum[0];
        psum[2]=s[2]+psum[1];

        for (int i = 3; i <32 ; i++) {
            s[i]=psum[i-2];
            psum[i]=s[i]+psum[i-1];
            //System.out.println(i+": "+s[i]+" : "+psum[i]);
        }

        int count=0;
        for (int i = 31; i >=2; i--) {
            if((n&(1<<i))!=0) {
                count += psum[i - 1];
                n -= (1 << i);
                if ((n & (1 << (i - 1))) != 0) {
                    //count+=psum[i-2];
                    //n-= (1 << (i - 1));
                    //if ((n&(1<<(i-2)))==0)
                        n=(1<<(i-1))-1;
                }
            }
        }
        if (n>=2)count+=psum[1];
        else if(n>=1)count+=psum[0];
        else count+=1;
        return count;
    }
}