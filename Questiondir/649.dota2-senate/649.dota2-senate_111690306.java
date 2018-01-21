public class Solution {
    public String predictPartyVictory(String senate) {
        int n=senate.length(),now=0,R=0,D=0,nextR=0,nextD=0;
        for (int i=0;i<n;i++)
            if (senate.charAt(i)=='R') R++; else D++;
        boolean[] bo=new boolean[n];
        while (R>0 && D>0)
        {
            while (bo[now]) now=(now+1)%n;
            nextD=now;
            nextR=now;
            while (bo[nextD] || senate.charAt(nextD)=='R') nextD=(nextD+1)%n;
            while (bo[nextR] || senate.charAt(nextR)=='D') nextR=(nextR+1)%n;
            if (senate.charAt(now)=='R')
            {
                D--;
                if (D==0) break;
                bo[nextD]=true;
            }
            else
            {
                R--;
                if (R==0) break;
                bo[nextR]=true;
            }
            now=(now+1)%n;
        }
        if (R==0) return "Dire"; else return "Radiant";
    }
}